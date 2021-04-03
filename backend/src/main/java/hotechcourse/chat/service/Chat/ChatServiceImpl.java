package hotechcourse.chat.service.chat;

import hotechcourse.chat.dto.chat.ChatReadDto;
import hotechcourse.chat.entity.Chat;
import hotechcourse.chat.repository.chat.ChatRepository;
import hotechcourse.chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    @Override
    public Long createChat(List<Long> users) {
        ArrayList<String> userNames = new ArrayList<>();
        for (Long user : users) {
            userNames.add(userRepository.findById(user).orElseThrow().getName());
        }
        String chatName = userNames.get(0) + " 와 " + userNames.get(1) + " 의 채팅방";
        return chatRepository.save(new Chat(chatName, users)).getId();
    }

    @Override
    public List<ChatReadDto> readChat(Long id) {
        return chatRepository.findChatList(id.toString()).stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private ChatReadDto convertToDto(Chat chat) {
        return ChatReadDto.builder()
                .id(chat.getId())
                .name(chat.getName())
                .update_at(chat.getUpdate_at())
                .build();
    }
}
