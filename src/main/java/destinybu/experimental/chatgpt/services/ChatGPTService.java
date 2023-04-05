package destinybu.experimental.chatgpt.services;

import destinybu.experimental.chatgpt.models.ChatGPTAIModelsResponse;
import destinybu.experimental.chatgpt.models.ChatGPTCompletionResponse;
import destinybu.experimental.core.services.RestTemplateService;
import destinybu.experimental.models.request.ChatGPTCompletionRequestBody;
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
    private final HttpHeaders chatGptHttpHeaders;
    private final RestTemplateService restTemplateService;

    public ChatGPTService(@Value("${chat.gpt.models}") String modelsURL,
                          @Value("${chat.gpt.completions}") String completionsURL,
                          RestTemplateService restTemplateService,
                          @Qualifier("chatGPTHttpHeaders") HttpHeaders chatGptHttpHeaders) {
        this.modelsURL = modelsURL;
        this.completionsURL = completionsURL;
        this.restTemplateService = restTemplateService;
        this.chatGptHttpHeaders = chatGptHttpHeaders;
    }

    public String helloWorld() {
        return getCompletion(HELLO_WORLD_PROMPT).getChoices().get(0).getText();
    }

    public ChatGPTAIModelsResponse getModels() {
        return restTemplateService.get(modelsURL, chatGptHttpHeaders, ChatGPTAIModelsResponse.class);
    }

    public ChatGPTCompletionResponse getCompletion(String prompt) {
        ChatGPTCompletionRequestBody requestBody = ChatGPTCompletionRequestBody.builder().prompt(prompt).build();
        return restTemplateService.post(completionsURL, requestBody, chatGptHttpHeaders, ChatGPTCompletionResponse.class);
    }

}
