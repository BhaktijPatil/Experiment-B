package destinybu.experimental.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import destinybu.experimental.models.ChatGPTAIModel;
import destinybu.experimental.models.ChatGPTCommonResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatGPTAIModelsResponseBody extends ChatGPTCommonResponse {

    @JsonProperty("data")
    private List<ChatGPTAIModel> data;

}
