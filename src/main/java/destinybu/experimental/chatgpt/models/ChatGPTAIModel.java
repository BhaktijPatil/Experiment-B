package destinybu.experimental.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class ChatGPTAIModel extends ChatGPTCommonResponse {

    @JsonProperty("owned_by")
    private String ownedBy;

    @JsonProperty("permission")
    private List<ChatGPTAIModelPermissions> permission;

    @JsonProperty("root")
    private String root;

    @JsonProperty("parent")
    private String parent;

}