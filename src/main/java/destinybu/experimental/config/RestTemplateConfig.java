package destinybu.experimental.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class RestTemplateConfig {

    @Value("${chat.gpt.secret.key}")
    private String chatGPTSecretKey;

    @Bean("chatGPTHttpHeaders")
    HttpHeaders getChatGPTHttpHeaders() {
        HttpHeaders chatGptHttpHeaders = new HttpHeaders();
        chatGptHttpHeaders.setContentType(MediaType.APPLICATION_JSON);
        chatGptHttpHeaders.setBearerAuth(chatGPTSecretKey);
        return chatGptHttpHeaders;
    }

    @Bean
    RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // Register the MappingJackson2HttpMessageConverter to convert Java Objects to request body
        restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
        return restTemplate;
    }
}
