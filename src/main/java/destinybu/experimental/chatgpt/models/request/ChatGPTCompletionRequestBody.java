package destinybu.experimental.chatgpt.models.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ChatGPTCompletionRequestBody {

    @JsonProperty("model")
    private String modelId;

    @JsonProperty("prompt")
    private Object prompt; // can be string, array of strings, array of tokens, or array of token arrays

    @JsonProperty("suffix")
    @Builder.Default
    private String suffix = null;

    @JsonProperty("max_tokens")
    @Builder.Default
    private int maxTokens = 16;

    @JsonProperty("temperature")
    @Builder.Default
    private double temperature = 1.0;

    @JsonProperty("top_p")
    @Builder.Default
    private double topP = 1.0;

    @JsonProperty("n")
    @Builder.Default
    private int numCompletions = 1;

    @JsonProperty("stream")
    @Builder.Default
    private boolean isStream = false;

    @JsonProperty("logprobs")
    @Builder.Default
    private Integer logProbs = null;

    @JsonProperty("echo")
    @Builder.Default
    private boolean isEcho = false;

    @JsonProperty("stop")
    @Builder.Default
    private Object stopSequences = null;

    @JsonProperty("presence_penalty")
    @Builder.Default
    private double presencePenalty = 0.0;

    @JsonProperty("frequency_penalty")
    @Builder.Default
    private double frequencyPenalty = 0.0;

    @JsonProperty("best_of")
    @Builder.Default
    private int bestOf = 1;
}