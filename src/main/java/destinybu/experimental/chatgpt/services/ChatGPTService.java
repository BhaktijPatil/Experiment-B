package destinybu.experimental.chatgpt.services;

import destinybu.experimental.chatgpt.constants.ChatGPTCompletionsAIModels;
import destinybu.experimental.chatgpt.models.ChatGPTAIModelsResponse;
import destinybu.experimental.chatgpt.models.ChatGPTChatCompletionResponse;
import destinybu.experimental.chatgpt.models.ChatGPTCompletionResponse;
import destinybu.experimental.chatgpt.models.request.ChatGPTChatCompletionRequestBody;
import destinybu.experimental.chatgpt.models.request.ChatGPTCompletionRequestBody;
import destinybu.experimental.core.services.RestTemplateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatGPTService {

    private static final String HELLO_WORLD_PROMPT = "I'm writing a hello world program and calling you to get its response! Please work!";
    private final String modelsURL;
    private final String completionsURL;
    private final String chatURL;
    private final HttpHeaders chatGptHttpHeaders;
    private final RestTemplateService restTemplateService;

    public ChatGPTService(@Value("${chat.gpt.models}") String modelsURL,
                          @Value("${chat.gpt.completions}") String completionsURL,
                          @Value("${chat.gpt.chat}") String chatURL,
                          RestTemplateService restTemplateService,
                          @Qualifier("chatGPTHttpHeaders") HttpHeaders chatGptHttpHeaders) {
        this.modelsURL = modelsURL;
        this.completionsURL = completionsURL;
        this.chatURL = chatURL;
        this.restTemplateService = restTemplateService;
        this.chatGptHttpHeaders = chatGptHttpHeaders;
    }

    public String helloWorld() {
        return getCompletion(ChatGPTCompletionRequestBody.builder()
                .prompt(HELLO_WORLD_PROMPT)
                .modelId(ChatGPTCompletionsAIModels.TEXT_DAVINCI_003)
                .build())
                .getChoices()
                .get(0)
                .getText();
    }

    public ChatGPTAIModelsResponse getModels() {
        return restTemplateService.get(modelsURL, chatGptHttpHeaders, ChatGPTAIModelsResponse.class);
    }

    public ChatGPTCompletionResponse getCompletion(ChatGPTCompletionRequestBody requestBody) {
        return restTemplateService.post(completionsURL, requestBody, chatGptHttpHeaders, ChatGPTCompletionResponse.class);
    }

    public ChatGPTChatCompletionResponse getChatCompletion(ChatGPTChatCompletionRequestBody requestBody) {
        return restTemplateService.post(chatURL, requestBody, chatGptHttpHeaders, ChatGPTChatCompletionResponse.class);
    }

}
