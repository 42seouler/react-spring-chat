package hotechcourse.chat.service.Chat;

import hotechcourse.chat.entity.Chat;
import hotechcourse.chat.entity.User;
import hotechcourse.chat.repository.ChatRepository;
import hotechcourse.chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    @Override
    public Long createChat(List<Long> users) {
        for (Long user : users)
            userRepository.findById(user).orElseThrow();
    return chatRepository.save(new Chat(users)).getId();
    }
}
