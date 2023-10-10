package destinybu.experimental.recommendation.engine.models.recommendations;

import com.fasterxml.jackson.annotation.JsonInclude;
import destinybu.experimental.recommendation.engine.enums.RecommendationAIMood;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecommendationEngine {
    @Builder.Default
    private destinybu.experimental.recommendation.engine.enums.RecommendationEngine engine = destinybu.experimental.recommendation.engine.enums.RecommendationEngine.CHAT_GPT;

    @Builder.Default
    private RecommendationAIMood mood = RecommendationAIMood.FUNNY;
}