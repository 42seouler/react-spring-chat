package hotechcourse.chat.service.ChatMessage;

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

    @Override
    public ChatMessage getChatMessage() {
        return new ChatMessage(null, null, null);
    }
}
