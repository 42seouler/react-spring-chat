package seouler.chatting.controller;

import lombok.Data;

@Data
public class ChatMessageDto {

    private Long    author;
    private Long    chatroom;
    private String  content;
}
