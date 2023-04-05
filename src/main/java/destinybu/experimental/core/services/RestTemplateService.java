package destinybu.experimental.core.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.MessageFormat;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestTemplateService {

    private final RestTemplate restTemplate;

    public <T> T get(String url, HttpHeaders headers, Class<T> responseType) {
        log.info(MessageFormat.format("GET::REST Call started to URL : {0}", url));
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(headers), responseType);
        return handleResponse(responseEntity, url);
    }

    public <T> T post(String url, Object requestBody, HttpHeaders headers, Class<T> responseType) {
        log.info(MessageFormat.format("POST::REST Call started to URL : {0}", url));
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, responseType);
        return handleResponse(responseEntity, url);
    }

    private <T> T handleResponse(ResponseEntity<T> responseEntity, String url) {
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info(MessageFormat.format("SUCCESS::REST Call completed for API - {0} with status code - {1}", url, responseEntity.getStatusCode()));
            return responseEntity.getBody();
        } else {
            throw new RuntimeException(MessageFormat.format("ERROR::REST Call failed for API - {0} with status code - {1}", url, responseEntity.getStatusCode()));
        }
    }

}
