package seouler.chatting.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seouler.chatting.entity.ChatRoom;
import seouler.chatting.service.ChatRoomService;

@RestController
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomService chatRoomService;

    @PostMapping("/api/v1/chatroom")
    public ChatRoom createChatroom(@RequestBody ChatRoomDto chatRoomDto) {
        ChatRoom chatRoom = chatRoomService.create(chatRoomDto);
        return chatRoom;
    }

}
