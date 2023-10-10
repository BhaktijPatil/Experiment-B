package destinybu.experimental.chatgpt.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class ChatGPTChatCompletionResponse extends ChatGPTCommonResponse {

    @JsonProperty("choices")
    private List<ChatGPTChatChoice> choices;

    @JsonProperty("usage")
    private ChatGPTUsage usage;

    @Data
    public static class ChatGPTChatChoice {

        @JsonProperty("index")
        private int index;

        @JsonProperty("message")
        private ChatGPTChatMessage message;

        @JsonProperty("finish_reason")
        private String finishReason;
    }

    @Data
    public static class ChatGPTChatMessage {

        @JsonProperty("role")
        private String role;

        @JsonProperty("content")
        private String content;
    }
}
