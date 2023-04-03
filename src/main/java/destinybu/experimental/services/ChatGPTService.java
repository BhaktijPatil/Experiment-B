package destinybu.experimental.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
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
    @Autowired
    @Qualifier("chatGPTHttpHeaders")
    private HttpHeaders chatGptHttpHeaders;

    public String helloWorld() {
        return null;
    }

    public Object getModels() throws URISyntaxException {
        RequestEntity<Void> requestEntity = RequestEntity.get(new URI(modelsURL)).headers(chatGptHttpHeaders).build();
        log.info(MessageFormat.format("GET::Started fetching AI models from Open API - {0}", requestEntity.getUrl()));
        ResponseEntity<Object> responseEntity = new RestTemplate().exchange(requestEntity, Object.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info(MessageFormat.format("GET::Fetched AI models from Open API. Status Code - {0}", responseEntity.getStatusCode()));
            return responseEntity.getBody();
        } else {
            log.error(MessageFormat.format("GET::Failed to fetch AI models from Open API. Status Code - {0}", responseEntity.getStatusCode()));
            throw new RuntimeException("Failed to fetch AI models from Open API");
        }
    }
}
