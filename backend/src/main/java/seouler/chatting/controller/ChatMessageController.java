package seouler.chatting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seouler.chatting.entity.ChatMessage;
import seouler.chatting.entity.ChatNotification;
import seouler.chatting.service.ChatMessageService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatMessageController {

    private final ChatMessageService    chatMessageService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @PostMapping("/api/v1/message")
    public ChatMessage create(@RequestBody ChatMessageDto chatMessageDto) {
        return chatMessageService.create(chatMessageDto);
    }

    @MessageMapping("/chat")
    public void message(@Payload ChatMessageDto messageDto) {
        ChatMessage chatMessage = chatMessageService.create(messageDto);
        List<Long> participants = chatMessage.getChatRoom().getParticipant();
        participants.remove(messageDto.getAuthor());
        participants.forEach(participant -> simpMessagingTemplate.convertAndSendToUser(participant.toString(), "/queue/messages",
                new ChatNotification()));

    }

}
