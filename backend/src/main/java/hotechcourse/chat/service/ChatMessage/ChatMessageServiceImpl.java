package hotechcourse.chat.service.chatMessage;

import hotechcourse.chat.entity.ChatMessage;
import hotechcourse.chat.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;

    public Long createChatMessage() {
        return 1L;
    }
}
