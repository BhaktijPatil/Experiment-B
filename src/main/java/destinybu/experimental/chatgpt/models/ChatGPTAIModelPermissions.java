package destinybu.experimental.chatgpt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChatGPTAIModelPermissions extends ChatGPTCommonResponse {

    @JsonProperty("allow_create_engine")
    private boolean allowCreateEngine;

    @JsonProperty("allow_sampling")
    private boolean allowSampling;

    @JsonProperty("allow_logprobs")
    private boolean allowLogProbs;

    @JsonProperty("allow_search_indices")
    private boolean allowSearchIndices;

    @JsonProperty("allow_view")
    private boolean allowView;

    @JsonProperty("allow_fine_tuning")
    private boolean allowFineTuning;

    @JsonIgnore
    @JsonProperty("organization")
    private String organization;

    @JsonIgnore
    @JsonProperty("group")
    private String group;

    @JsonIgnore
    @JsonProperty("is_blocking")
    private boolean isBlocking;

}





