package destinybu.experimental.recommendation.engine.services;

import destinybu.experimental.chatgpt.models.ChatGPTChatCompletionResponse;
import destinybu.experimental.chatgpt.models.request.ChatGPTChatCompletionRequestBody;
import destinybu.experimental.chatgpt.services.ChatGPTService;
import destinybu.experimental.recommendation.engine.enums.GameStore;
import destinybu.experimental.recommendation.engine.interfaces.RecommendationService;
import destinybu.experimental.recommendation.engine.models.recommendations.GameRecommendation;
import destinybu.experimental.recommendation.engine.models.recommendations.request.GameRecommendationRequest;
import destinybu.experimental.steam.models.PlayerOwnedGame;
import destinybu.experimental.steam.models.SteamResponse;
import destinybu.experimental.steam.services.SteamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.MessageFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class ChatGPTGameRecommendationService implements RecommendationService<GameRecommendationRequest, GameRecommendation<ChatGPTChatCompletionResponse>> {

    public static final String GAME_STATS_PREFIX_PROMPT = "List of the top {0} games the player has played in format - [Game Name = Play time (Hours)] \n {1}";
    private static final BigDecimal MINUTES_IN_HOUR = BigDecimal.valueOf(60);
    private static final int PLAYTIME_ACCURACY_SCALE = 2;
    private static final int TOP_N_GAMES = 20;

    private final ChatGPTService chatGPTService;
    private final SteamService steamService;

    @Override
    public GameRecommendation<ChatGPTChatCompletionResponse> recommend(GameRecommendationRequest request) {

        String systemPrompt = "You are a game recommendation system, analyse user's game library and recommend him games. Be insulting in your recommendations";
        String gameDetailsPrompt;

        if (Objects.requireNonNull(request.getStoreDetails().getGameStore()) == GameStore.STEAM) {
            SteamResponse response = steamService.getPlayerOwnedGames(request.getStoreDetails().getGameStoreID());
            Map<String, BigDecimal> gameStatistics = response.getPlayerOwnedGames()
                    .stream()
                    .sorted(Comparator.comparingInt(PlayerOwnedGame::getPlaytimeForever).reversed())
                    .limit(TOP_N_GAMES)
                    .collect(Collectors.toMap(
                            PlayerOwnedGame::getName,
                            playerOwnedGame -> (BigDecimal.valueOf(playerOwnedGame.getPlaytimeForever())
                                    .divide(MINUTES_IN_HOUR, PLAYTIME_ACCURACY_SCALE, RoundingMode.HALF_UP))
                    ));

            gameDetailsPrompt = MessageFormat.format(GAME_STATS_PREFIX_PROMPT, TOP_N_GAMES, gameStatistics);
            log.info(gameDetailsPrompt);

        } else {
            throw new IllegalArgumentException();
        }

        List<ChatGPTChatCompletionRequestBody.Message> recommendationPrompts = List.of(
                ChatGPTChatCompletionRequestBody.Message.builder()
                        .role("system")
                        .content(systemPrompt)
                        .build(),
                ChatGPTChatCompletionRequestBody.Message.builder()
                        .role("user")
                        .content(gameDetailsPrompt)
                        .build());

        ChatGPTChatCompletionResponse recommendation = chatGPTService.getChatCompletion(ChatGPTChatCompletionRequestBody.builder()
                .messages(recommendationPrompts)
                .build());

        return GameRecommendation.<ChatGPTChatCompletionResponse>builder()
                .recommendation(recommendation)
                .build();
    }
}
