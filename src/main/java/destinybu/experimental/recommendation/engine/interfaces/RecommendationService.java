package destinybu.experimental.recommendation.engine.interfaces;

public interface RecommendationService<T, R> {
    R recommend(T recommendationInput);
}
