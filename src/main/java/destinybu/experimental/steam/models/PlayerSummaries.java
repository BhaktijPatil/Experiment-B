package destinybu.experimental.steam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PlayerSummaries {

    @JsonProperty("steamid")
    private String steamId;

    @JsonProperty("communityvisibilitystate")
    private int communityVisibilityState;

    @JsonProperty("profilestate")
    private int profileState;

    @JsonProperty("personaname")
    private String personaName;

    @JsonProperty("profileurl")
    private String profileUrl;

    @JsonProperty("avatar")
    private String avatar;

    @JsonIgnore
    @JsonProperty("avatarmedium")
    private String avatarMedium;

    @JsonIgnore
    @JsonProperty("avatarfull")
    private String avatarFull;

    @JsonIgnore
    @JsonProperty("avatarhash")
    private String avatarHash;

    @JsonIgnore
    @JsonProperty("personastate")
    private int personaState;

    @JsonProperty("realname")
    private String realName;

    @JsonProperty("primaryclanid")
    private String primaryClanId;

    @JsonProperty("timecreated")
    private long timeCreated;

    @JsonProperty("personastateflags")
    private int personaStateFlags;

    @JsonProperty("loccountrycode")
    private String locCountryCode;

    @JsonProperty("locstatecode")
    private String locStateCode;

    @JsonProperty("loccityid")
    private int locCityId;

}