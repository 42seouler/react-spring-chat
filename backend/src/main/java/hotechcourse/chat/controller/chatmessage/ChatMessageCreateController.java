package hotechcourse.chat.controller.chatmessage;

import hotechcourse.chat.dto.chatmessage.ChatMessageCreateDto;
import hotechcourse.chat.service.chatMessage.ChatMessageService;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ChatMessageCreateController {

    private final ChatMessageService chatMessageService;

    @PostMapping("/api/v1/chatmessage")
    public Response chatMessageCreate(@RequestBody @Valid Request request) {
        return Response.builder()
                .chatMessageId(chatMessageService.createChatMessage(convertToDto(request)))
                .build();
    }

    @Data
    @NoArgsConstructor
    public static class Request {

        private Long    chatId;
        private Long    authorId;
        private String  content;

        @Builder
        public Request(Long chatId, Long authorId, String content) {
            this.chatId = chatId;
            this.authorId = authorId;
            this.content = content;
        }
    }

    @Data
    @NoArgsConstructor
    public static class Response {

        private Long chatMessageId;

        @Builder
        public Response(Long chatMessageId) {
            this.chatMessageId = chatMessageId;
        }
    }

    public ChatMessageCreateDto convertToDto(Request request) {

        return ChatMessageCreateDto.builder()
                .chatId(request.getChatId())
                .authorId(request.authorId)
                .content(request.content)
                .build();
    }
}
