package hotechcourse.chat.controller.chat;

import hotechcourse.chat.service.chat.ChatService;
import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatCreateController {

    private final ChatService chatService;

    @PostMapping("/api/v1/chat")
    public Response createChat(@RequestBody @Valid Request request) {
        Long chatId = chatService.createChat(request.getUsers());
        return Response.builder()
                .id(chatId)
                .build();
    }

    @Data
    @NoArgsConstructor
    public static class Request {
        private List<Long>  users = new ArrayList<>();

        public Request(List<Long> users) {
            this.users = users;
        }
    }

    @Data
    @NoArgsConstructor
    public static class Response {
        private Long    id;

        @Builder
        public Response(Long id) {
            this.id = id;
        }
    }
}
