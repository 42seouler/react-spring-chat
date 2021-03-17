package seouler.chatting.controller;

import lombok.Data;

import java.util.List;

@Data
public class ChatRoomDto {

    private List<Long> participants;
}
