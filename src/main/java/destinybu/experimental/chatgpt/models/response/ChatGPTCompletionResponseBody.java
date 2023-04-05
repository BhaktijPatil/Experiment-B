package destinybu.experimental.models.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import destinybu.experimental.models.ChatGPTCommonResponse;
import destinybu.experimental.models.ChatGPTCompletionChoice;
import destinybu.experimental.models.ChatGPTCompletionUsage;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChatGPTCompletionResponseBody extends ChatGPTCommonResponse {

    @JsonProperty("model")
    private String model;

    @JsonProperty("choices")
    private List<ChatGPTCompletionChoice> choices;

    @JsonProperty("usage")
    private ChatGPTCompletionUsage usage;

}