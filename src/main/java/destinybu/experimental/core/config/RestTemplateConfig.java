package destinybu.experimental.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Configuration
public class RestTemplateConfig {

    @Bean
    RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // Register the MappingJackson2HttpMessageConverter to convert Java Objects to request body
        restTemplate.setMessageConverters(Collections.singletonList(new MappingJackson2HttpMessageConverter()));
        return restTemplate;
    }

}
