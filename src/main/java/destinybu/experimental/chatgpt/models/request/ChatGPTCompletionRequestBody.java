package destinybu.experimental.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ChatGPTCompletionRequestBody {

    private String prompt;
    @Builder.Default
    private String model = "text-davinci-003";
    @Builder.Default
    private Integer max_tokens = 2048;
    private Integer temperature;

}
