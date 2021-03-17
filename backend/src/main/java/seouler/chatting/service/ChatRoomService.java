package seouler.chatting.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import seouler.chatting.controller.ChatRoomDto;
import seouler.chatting.entity.ChatRoom;
import seouler.chatting.entity.User;
import seouler.chatting.repository.ChatRoomRepository;
import seouler.chatting.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final UserRepository     userRepository;

    public ChatRoom create(ChatRoomDto chatRoomDto) {
        List<User> allById = userRepository.findAllById(chatRoomDto.getParticipants());
        return chatRoomRepository.save(new ChatRoom(chatRoomDto.getParticipants(), "name"));
    }
}
