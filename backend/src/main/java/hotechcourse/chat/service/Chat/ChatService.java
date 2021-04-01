package hotechcourse.chat.service.chat;

import hotechcourse.chat.dto.chat.ChatReadDto;
import hotechcourse.chat.entity.Chat;

import java.util.List;

public interface ChatService {

    Long createChat(List<Long> users);

    List<ChatReadDto> readChat(Long id);
}
