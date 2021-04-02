package hotechcourse.chat.repository.chatmessage;

import hotechcourse.chat.entity.Chat;
import hotechcourse.chat.entity.ChatMessage;

import java.util.List;

public interface ChatMessageCustomRepository {

    List<ChatMessage> findByChatId(Long chatId);
}
