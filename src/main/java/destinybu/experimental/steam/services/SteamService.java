package destinybu.experimental.steam.services;

import destinybu.experimental.core.services.RestTemplateService;
import destinybu.experimental.steam.models.SteamCommonResponse;
import destinybu.experimental.steam.models.SteamResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

@Service
@Slf4j
public class SteamService {

    private static final String JSON_FORMAT = "json";
    private static final Boolean INCLUDE_APP_INFO = true;
    private static final Boolean INCLUDE_PLAYED_FREE_GAMES = true;

    private final String playerSummariesURL;
    private final String playerOwnedGamesURL;
    private final String steamAPIKey;

    private final RestTemplateService restTemplateService;

    public SteamService(@Value("${steam.get.player.summaries}") String playerSummariesURL,
                        @Value("${steam.get.player.games}") String playerOwnedGamesURL,
                        @Value("${steam.secret.key}") String steamAPIKey,
                        RestTemplateService restTemplateService) {
        this.playerSummariesURL = playerSummariesURL;
        this.playerOwnedGamesURL = playerOwnedGamesURL;
        this.steamAPIKey = steamAPIKey;
        this.restTemplateService = restTemplateService;
    }

    public SteamResponse getPlayerSummaries(String steamID) {
        return restTemplateService.get(MessageFormat.format(playerSummariesURL, steamAPIKey, steamID),
                        null, SteamCommonResponse.class)
                .getSteamResponse();
    }

    public SteamResponse getPlayerOwnedGames(String steamID) {
        return restTemplateService.get(MessageFormat.format(playerOwnedGamesURL, steamAPIKey, steamID,
                        JSON_FORMAT, INCLUDE_APP_INFO, INCLUDE_PLAYED_FREE_GAMES), null, SteamCommonResponse.class)
                .getSteamResponse();
    }
}
