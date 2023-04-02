package destinybu.experimental.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "Chat-GPT", path = "/chat-gpt")
public class ChatGPTController {

    @GetMapping("/test")
    public Object testApi() {
        return "Hello World";
    }

}
