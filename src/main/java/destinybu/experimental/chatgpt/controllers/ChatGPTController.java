package destinybu.experimental.chatgpt.controllers;

import destinybu.experimental.chatgpt.services.ChatGPTService;
import destinybu.experimental.models.ChatGPTCompletionChoice;
import destinybu.experimental.models.response.ChatGPTAIModelsResponseBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "Chat-GPT", path = "/chat-gpt")
@RequiredArgsConstructor
public class ChatGPTController {

    private final ChatGPTService chatGPTService;

    @GetMapping("/hello-world")
    public String test() {
        return chatGPTService.helloWorld();
    }

    @GetMapping("/completions/{prompt}")
    public List<String> getCompletion(@PathVariable String prompt) {
        return chatGPTService.getCompletion(prompt).getChoices().stream().map(ChatGPTCompletionChoice::getText).toList();
    }

    @GetMapping("/models")
    public ChatGPTAIModelsResponseBody getChatGPTModels() {
        return chatGPTService.getModels();
    }

}
