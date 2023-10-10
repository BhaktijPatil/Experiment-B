package destinybu.experimental.steam.controllers;

import destinybu.experimental.steam.models.SteamResponse;
import destinybu.experimental.steam.services.SteamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "Steam", path = "/steam/{steamID}")
@RequiredArgsConstructor
public class SteamController {

    private final SteamService steamService;

    @GetMapping("/summary")
    public SteamResponse getPlayerSummary(@PathVariable String steamID) {
        return steamService.getPlayerSummaries(steamID);
    }

    @GetMapping("/games")
    public SteamResponse getPlayerOwnedGames(@PathVariable String steamID) {
        return steamService.getPlayerOwnedGames(steamID);
    }
}
