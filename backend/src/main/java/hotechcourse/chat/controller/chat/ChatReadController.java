package hotechcourse.chat.controller.chat;

import hotechcourse.chat.dto.chat.ChatReadDto;
import hotechcourse.chat.service.chat.ChatService;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatReadController {

    private final ChatService chatService;

    @GetMapping("/api/v1/chat")
    public Response ReadChat(@Valid Request request) {
        return Response.builder()
                .chatList(chatService.readChat(request.getId()))
                .build();
    }

    @Data
    @NoArgsConstructor
    public static class Request {

        private Long id;

        public Request(Long id) {
            this.id = id;
        }
    }

    @Data
    @NoArgsConstructor
    public static class Response {

        private List<ChatReadDto> ChatList = new ArrayList<>();

        @Builder
        public Response(List<ChatReadDto> chatList) {
            ChatList = chatList;
        }
    }
}
