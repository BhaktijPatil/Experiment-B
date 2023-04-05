package destinybu.experimental.chatgpt.models;

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
    private ChatGPTCompletionUsage usage;

}