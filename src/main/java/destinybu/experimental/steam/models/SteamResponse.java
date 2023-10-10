package destinybu.experimental.steam.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SteamResponse {

    @JsonProperty("game_count")
    private Integer gameCount;

    @JsonProperty("games")
    private List<PlayerOwnedGame> playerOwnedGames;

    @JsonProperty("players")
    private List<PlayerSummaries> playerSummariesList;

}
