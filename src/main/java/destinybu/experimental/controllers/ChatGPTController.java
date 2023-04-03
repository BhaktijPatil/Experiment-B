package destinybu.experimental.controllers;

import destinybu.experimental.services.ChatGPTService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping(name = "Chat-GPT", path = "/chat-gpt")
@RequiredArgsConstructor
public class ChatGPTController {

    private final ChatGPTService chatGPTService;

    @GetMapping("/test")
    public Object testAPI() {
        return chatGPTService.helloWorld();
    }

    @GetMapping("/models")
    public Object getChatGPTModels() throws URISyntaxException {
        return chatGPTService.getModels();
    }
}
