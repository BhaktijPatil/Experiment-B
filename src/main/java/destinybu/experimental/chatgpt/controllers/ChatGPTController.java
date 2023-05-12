package destinybu.experimental.chatgpt.controllers;

import destinybu.experimental.chatgpt.constants.ChatGPTCompletionsAIModels;
import destinybu.experimental.chatgpt.models.ChatGPTAIModelsResponse;
import destinybu.experimental.chatgpt.models.ChatGPTCompletionChoice;
import destinybu.experimental.chatgpt.services.ChatGPTService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public List<String> getCompletion(@PathVariable String prompt, @RequestParam(required = false, defaultValue =
            ChatGPTCompletionsAIModels.TEXT_DAVINCI_003) String modelId) {
        return chatGPTService.getCompletion(prompt, modelId)
                .getChoices()
                .stream()
                .map(ChatGPTCompletionChoice::getText).toList();
    }

    @GetMapping("/models")
    public ChatGPTAIModelsResponse getChatGPTModels() {
        return chatGPTService.getModels();
    }

}
