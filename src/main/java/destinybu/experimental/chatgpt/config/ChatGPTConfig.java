package destinybu.experimental.chatgpt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@Configuration
public class ChatGPTConfig {
    @Value("${chat.gpt.secret.key}")
    private String chatGPTSecretKey;

    @Bean("chatGPTHttpHeaders")
    HttpHeaders getChatGPTHttpHeaders() {
        HttpHeaders chatGptHttpHeaders = new HttpHeaders();
        chatGptHttpHeaders.setContentType(MediaType.APPLICATION_JSON);
        chatGptHttpHeaders.setBearerAuth(chatGPTSecretKey);
        return chatGptHttpHeaders;
    }

}
