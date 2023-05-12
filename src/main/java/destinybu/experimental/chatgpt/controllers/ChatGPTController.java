package destinybu.experimental.chatgpt.controllers;

import destinybu.experimental.chatgpt.models.ChatGPTAIModelsResponse;
import destinybu.experimental.chatgpt.models.ChatGPTChatCompletionResponse;
import destinybu.experimental.chatgpt.models.ChatGPTCompletionResponse;
import destinybu.experimental.chatgpt.models.request.ChatGPTChatCompletionRequestBody;
import destinybu.experimental.chatgpt.models.request.ChatGPTCompletionRequestBody;
import destinybu.experimental.chatgpt.services.ChatGPTService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(name = "Chat-GPT", path = "/chat-gpt")
@RequiredArgsConstructor
public class ChatGPTController {

    private final ChatGPTService chatGPTService;

    @GetMapping("/hello-world")
    public String test() {
        return chatGPTService.helloWorld();
    }

    @GetMapping("/models")
    public ChatGPTAIModelsResponse getChatGPTModels() {
        return chatGPTService.getModels();
    }

    @PostMapping("/completions")
    public ChatGPTCompletionResponse getCompletion(@RequestBody ChatGPTCompletionRequestBody requestBody) {
        return chatGPTService.getCompletion(requestBody);
    }

    @PostMapping("/chat")
    public ChatGPTChatCompletionResponse getChatCompletion(@RequestBody ChatGPTChatCompletionRequestBody requestBody) {
        return chatGPTService.getChatCompletion(requestBody);
    }
}
