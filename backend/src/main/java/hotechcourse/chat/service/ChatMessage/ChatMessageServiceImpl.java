package hotechcourse.chat.service.chatMessage;

import hotechcourse.chat.dto.chatmessage.ChatMessageCreateDto;
import hotechcourse.chat.dto.chatmessage.ChatMessageReadDto;
import hotechcourse.chat.entity.Chat;
import hotechcourse.chat.entity.ChatMessage;
import hotechcourse.chat.entity.User;
import hotechcourse.chat.repository.chatmessage.ChatMessageRepository;
import hotechcourse.chat.repository.chat.ChatRepository;
import hotechcourse.chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatRepository        chatRepository;
    private final UserRepository        userRepository;

    @Override
    public Long createChatMessage(ChatMessageCreateDto dto) {
        User author = userRepository.findById(dto.getAuthorId()).orElseThrow();
        Chat chat = chatRepository.findById(dto.getChatId()).orElseThrow();
        return chatMessageRepository.save(ChatMessage.builder()
                .author(author)
                .chat(chat)
                .content(dto.getContent())
                .build())
                .getId();
    }

    @Override
    public List<ChatMessageReadDto> readChatMessage(Long chatId) {
        Chat chat = chatRepository.findById(chatId).orElseThrow();
        List<ChatMessage> byChatId = chatMessageRepository.findByChatId(chat.getId());
        return byChatId.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private ChatMessageReadDto convertToDto(ChatMessage chatMessage) {
        return ChatMessageReadDto.builder()
                .id(chatMessage.getId())
                .authorName(chatMessage.getAuthor().getName())
                .content(chatMessage.getContent())
                .timestamp(chatMessage.getTimestamp())
                .build();
    }
}
