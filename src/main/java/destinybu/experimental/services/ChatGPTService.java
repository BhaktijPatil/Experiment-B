package destinybu.experimental.services;

import destinybu.experimental.models.ChatGPTCompletionsRequestBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;

@Service
@Slf4j
public class ChatGPTService {

    @Value("${chat.gpt.models}")
    private String modelsURL;

    @Value("${chat.gpt.completions}")
    private String completionsURL;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    @Qualifier("chatGPTHttpHeaders")
    private HttpHeaders chatGptHttpHeaders;

    public Object helloWorld() {
        return getCompletion("Say Hello World!");
    }

    public Object getModels() throws URISyntaxException {
        RequestEntity<Void> requestEntity = RequestEntity.get(new URI(modelsURL)).headers(chatGptHttpHeaders).build();
        log.info(MessageFormat.format("GET::Started fetching AI models from Open API - {0}", requestEntity.getUrl()));
        ResponseEntity<Object> responseEntity = restTemplate.exchange(requestEntity, Object.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info(MessageFormat.format("GET::Fetched AI models from Open API. Status Code - {0}", responseEntity.getStatusCode()));
            return responseEntity.getBody();
        } else {
            log.error(MessageFormat.format("GET::Failed to fetch AI models from Open API. Status Code - {0}", responseEntity.getStatusCode()));
            throw new RuntimeException("Failed to fetch AI models from Open API");
        }
    }

    public Object getCompletion(String prompt) {
        log.info(MessageFormat.format("GET::Started fetching completion from - {0} for prompt - {1}", completionsURL, prompt));

        ChatGPTCompletionsRequestBody requestBody = ChatGPTCompletionsRequestBody.builder().prompt("Test").build();
        HttpEntity<ChatGPTCompletionsRequestBody> httpEntity = new HttpEntity<>(requestBody, chatGptHttpHeaders);

        ResponseEntity<Object> responseEntity = restTemplate.exchange(completionsURL, HttpMethod.POST, httpEntity, Object.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info(MessageFormat.format("GET::Fetched completion from Open API. Status Code - {0}", responseEntity.getStatusCode()));
            return responseEntity.getBody();
        } else {
            log.error(MessageFormat.format("GET::Failed to fetch completion from Open API. Status Code - {0}", responseEntity.getStatusCode()));
            throw new RuntimeException("Failed to fetch completion from Open API");
        }
    }
}
