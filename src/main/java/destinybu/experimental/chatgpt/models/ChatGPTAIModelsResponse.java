package destinybu.experimental.chatgpt.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatGPTAIModelsResponse extends ChatGPTCommonResponse {

    @JsonProperty("data")
    private List<ChatGPTAIModel> data;

}
