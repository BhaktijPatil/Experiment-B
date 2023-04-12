package destinybu.experimental.steam.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SteamCommonResponse {

    @JsonProperty("response")
    private SteamResponse steamResponse;
}