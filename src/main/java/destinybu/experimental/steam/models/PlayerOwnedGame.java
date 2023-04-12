package destinybu.experimental.steam.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerOwnedGame {

    @JsonProperty("appid")
    private int appId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("playtime_forever")
    private int playtimeForever;

    @JsonIgnore
    @JsonProperty("img_icon_url")
    private String imgIconUrl;

    @JsonProperty("has_community_visible_stats")
    private boolean hasCommunityVisibleStats;

    @JsonIgnore
    @JsonProperty("playtime_windows_forever")
    private int playtimeWindowsForever;

    @JsonIgnore
    @JsonProperty("playtime_mac_forever")
    private int playtimeMacForever;

    @JsonIgnore
    @JsonProperty("playtime_linux_forever")
    private int playtimeLinuxForever;

    @JsonIgnore
    @JsonProperty("rtime_last_played")
    private long rtimeLastPlayed;

    @JsonProperty("has_leaderboards")
    private boolean hasLeaderboards;
}
