package destinybu.experimental.chatgpt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ChatGPTCommonResponse {

    @JsonProperty("id")
    private String id;

    @JsonIgnore
    @JsonProperty("object")
    private String object;

    @JsonIgnore
    @JsonProperty("created")
    private Long created;

}
