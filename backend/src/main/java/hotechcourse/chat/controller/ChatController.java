package hotechcourse.chat.controller;

import hotechcourse.chat.service.Chat.ChatService;
import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/api/v1/chat")
    public CreateChatResponse createChat(@RequestBody @Valid CreateChatRequest request) {
        Long chatId = chatService.createChat(request.getUsers());
        return new CreateChatResponse(chatId);
    }

    @Data
    @NoArgsConstructor
    static class CreateChatRequest {
        private List<Long>  users = new ArrayList<>();

        public CreateChatRequest(List<Long> users) {
            this.users = users;
        }
    }

    @Data
    @NoArgsConstructor
    public static class CreateChatResponse {
        private Long    id;

        public CreateChatResponse(Long id) {
            this.id = id;
        }
    }
}
