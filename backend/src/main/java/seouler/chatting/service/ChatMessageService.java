package seouler.chatting.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seouler.chatting.controller.ChatMessageDto;
import seouler.chatting.entity.ChatMessage;
import seouler.chatting.entity.ChatRoom;
import seouler.chatting.repository.ChatMessageRepository;
import seouler.chatting.repository.ChatRoomRepository;
import seouler.chatting.repository.UserRepository;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomRepository    chatRoomRepository;
    private final UserRepository        userRepository;

    public ChatMessage create(ChatMessageDto chatMessageDto) {
        return chatMessageRepository.save(convertToEntity(chatMessageDto));

    }

    private ChatMessage convertToEntity(ChatMessageDto dto) {
        return new ChatMessage(
                userRepository.findById(dto.getAuthor()).get(),
                chatRoomRepository.findById(dto.getChatroom()).get(),
                dto.getContent()
        );
    }
}
