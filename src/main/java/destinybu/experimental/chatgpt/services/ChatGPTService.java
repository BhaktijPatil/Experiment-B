package destinybu.experimental.chatgpt.services;

import destinybu.experimental.models.request.ChatGPTCompletionRequestBody;
import destinybu.experimental.models.response.ChatGPTAIModelsResponseBody;
import destinybu.experimental.models.response.ChatGPTCompletionResponseBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
@Slf4j
public class ChatGPTService {

    private static final String HELLO_WORLD_PROMPT = "I'm writing a hello world program and calling you to get its response! Please work!";
    private final String modelsURL;
    private final String completionsURL;
    private final RestTemplate restTemplate;
    private final HttpHeaders chatGptHttpHeaders;

    public ChatGPTService(@Value("${chat.gpt.models}") String modelsURL,
                          @Value("${chat.gpt.completions}") String completionsURL,
                          RestTemplate restTemplate,
                          @Qualifier("chatGPTHttpHeaders") HttpHeaders chatGptHttpHeaders) {
        this.modelsURL = modelsURL;
        this.completionsURL = completionsURL;
        this.restTemplate = restTemplate;
        this.chatGptHttpHeaders = chatGptHttpHeaders;
    }

    public String helloWorld() {
        return getCompletion(HELLO_WORLD_PROMPT).getChoices().get(0).getText();
    }

    public ChatGPTAIModelsResponseBody getModels() {
        log.info("GET::Started fetching AI models from Open API - {}", modelsURL);

        ResponseEntity<ChatGPTAIModelsResponseBody> responseEntity = restTemplate.exchange(modelsURL, HttpMethod.GET,
                new HttpEntity<>(chatGptHttpHeaders), ChatGPTAIModelsResponseBody.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("GET::Fetched AI models from Open API. Status Code - {}", responseEntity.getStatusCode());
            return responseEntity.getBody();
        } else {
            log.error("GET::Failed to fetch AI models from Open API. Status Code - {}", responseEntity.getStatusCode());
            throw new RuntimeException("Failed to fetch AI models from Open API");
        }
    }

    public ChatGPTCompletionResponseBody getCompletion(String prompt) {
        log.info("POST::Started fetching completion from {} for prompt - {}", completionsURL, prompt);

        ChatGPTCompletionRequestBody requestBody = ChatGPTCompletionRequestBody.builder().prompt(prompt).build();
        HttpEntity<ChatGPTCompletionRequestBody> httpEntity = new HttpEntity<>(requestBody, chatGptHttpHeaders);

        ResponseEntity<ChatGPTCompletionResponseBody> responseEntity = restTemplate.exchange(completionsURL, HttpMethod.POST, httpEntity, ChatGPTCompletionResponseBody.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("POST::Fetched completion from Open API. Status Code - {}", responseEntity.getStatusCode());
            ChatGPTCompletionResponseBody responseBody = responseEntity.getBody();
            Objects.requireNonNull(responseBody, "Completions should not be null");
            return responseBody;
        } else {
            log.error("POST::Failed to fetch completion from Open API. Status Code - {}", responseEntity.getStatusCode());
            throw new RuntimeException("Failed to fetch completion from Open API");
        }
    }

}
