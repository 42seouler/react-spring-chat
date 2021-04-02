package hotechcourse.chat.controller.chatmessage;

import hotechcourse.chat.dto.chatmessage.ChatMessageReadDto;
import hotechcourse.chat.service.chatMessage.ChatMessageService;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatMessageReadController {

    private final ChatMessageService chatMessageService;

    @GetMapping("/api/v1/chatmessage")
    public Response chatMessageRead(@Valid Request request) {
        return Response.builder()
                .chatList(chatMessageService.readChatMessage(request.getChatId()))
                .build();
    }

    @Data
    @NoArgsConstructor
    public static class Request {

        private Long chatId;

        @Builder
        public Request(Long chatId) {
            this.chatId = chatId;
        }
    }

    @Data
    @NoArgsConstructor
    public static class Response {

        private List<ChatMessageReadDto> chatList = new ArrayList<>();

        @Builder
        public Response(List<ChatMessageReadDto> chatList) {
            this.chatList = chatList;
        }
    }
}
