package hotechcourse.chat.service.chatMessage;

import hotechcourse.chat.dto.chatmessage.ChatMessageCreateDto;
import hotechcourse.chat.dto.chatmessage.ChatMessageReadDto;
import hotechcourse.chat.entity.ChatMessage;

import java.util.List;

public interface ChatMessageService {

    Long createChatMessage(ChatMessageCreateDto dto);

    List<ChatMessageReadDto> readChatMessage(Long chatId);
}
