package destinybu.experimental.recommendation.engine.factories;

import destinybu.experimental.chatgpt.services.ChatGPTService;
import destinybu.experimental.recommendation.engine.enums.RecommendationEngine;
import destinybu.experimental.recommendation.engine.services.ChatGPTGameRecommendationService;
import destinybu.experimental.steam.services.SteamService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GameRecommendationServiceFactory {
    private final ChatGPTService chatGPTService;
    private final SteamService steamService;

    public ChatGPTGameRecommendationService createGameRecommendationService(@NonNull RecommendationEngine recommendationEngine) {
        if (recommendationEngine == RecommendationEngine.CHAT_GPT) {
            return new ChatGPTGameRecommendationService(chatGPTService, steamService);
        }
        return null;
    }
}