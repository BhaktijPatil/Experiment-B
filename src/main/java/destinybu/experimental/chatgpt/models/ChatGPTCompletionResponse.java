package destinybu.experimental.chatgpt.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChatGPTCompletionResponse extends ChatGPTCommonResponse {

    @JsonProperty("model")
    private String model;

    @JsonProperty("choices")
    private List<ChatGPTCompletionChoice> choices;

    @JsonProperty("usage")
    private ChatGPTUsage usage;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ChatGPTCompletionChoice {

        @JsonProperty("text")
        private String text;

        @JsonProperty("index")
        private Integer index;

        @JsonProperty("finish_reason")
        private String finishReason;

    }
}