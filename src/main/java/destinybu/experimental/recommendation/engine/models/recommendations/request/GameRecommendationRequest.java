package destinybu.experimental.recommendation.engine.models.recommendations.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import destinybu.experimental.recommendation.engine.models.recommendations.GameStore;
import destinybu.experimental.recommendation.engine.models.recommendations.RecommendationEngine;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameRecommendationRequest {

    private GameStore storeDetails;
    private RecommendationEngine engineDetails;
}
