package destinybu.experimental.chatgpt.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatGPTCompletionChoice {

    @JsonProperty("text")
    private String text;

    @JsonProperty("index")
    private Integer index;

    @JsonProperty("finish_reason")
    private String finishReason;

}
