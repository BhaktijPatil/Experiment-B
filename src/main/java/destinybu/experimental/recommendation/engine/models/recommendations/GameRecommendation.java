package destinybu.experimental.recommendation.engine.models.recommendations;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GameRecommendation<T> {
    T recommendation;
}
