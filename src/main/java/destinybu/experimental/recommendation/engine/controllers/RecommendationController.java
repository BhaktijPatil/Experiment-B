package destinybu.experimental.recommendation.engine.controllers;

import destinybu.experimental.recommendation.engine.models.recommendations.GameRecommendation;
import destinybu.experimental.recommendation.engine.models.recommendations.request.GameRecommendationRequest;
import destinybu.experimental.recommendation.engine.services.GamesRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "Game Recommendation Engine", path = "/games")
@RequiredArgsConstructor
public class RecommendationController {

    private final GamesRecommendationService gamesRecommendationService;

    @PostMapping("/recommendations")
    public GameRecommendation<?> getRecommendations(@RequestBody GameRecommendationRequest requestBody) {
        return gamesRecommendationService.getRecommendations(requestBody);
    }
}
