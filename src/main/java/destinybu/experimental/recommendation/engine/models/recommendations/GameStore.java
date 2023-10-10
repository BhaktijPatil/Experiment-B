package destinybu.experimental.recommendation.engine.models.recommendations;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;


@AllArgsConstructor
@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameStore {
    @NonNull
    private final String gameStoreID;

    @Builder.Default
    private final destinybu.experimental.recommendation.engine.enums.GameStore gameStore = destinybu.experimental.recommendation.engine.enums.GameStore.STEAM;
}
