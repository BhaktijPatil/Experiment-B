package destinybu.experimental.recommendation.engine.services;

import destinybu.experimental.recommendation.engine.factories.GameRecommendationServiceFactory;
import destinybu.experimental.recommendation.engine.interfaces.RecommendationService;
import destinybu.experimental.recommendation.engine.models.recommendations.GameRecommendation;
import destinybu.experimental.recommendation.engine.models.recommendations.request.GameRecommendationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class GamesRecommendationService {

    private final GameRecommendationServiceFactory gameRecommendationServiceFactory;

    public GameRecommendation<?> getRecommendations(GameRecommendationRequest gameRecommendationRequest) {
        RecommendationService<GameRecommendationRequest, ?> recommendationService = gameRecommendationServiceFactory
                .createGameRecommendationService(gameRecommendationRequest.getEngineDetails().getEngine());

        return (GameRecommendation<?>) recommendationService.recommend(gameRecommendationRequest);
    }
}
