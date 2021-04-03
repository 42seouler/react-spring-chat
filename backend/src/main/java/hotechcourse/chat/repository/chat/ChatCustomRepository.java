package hotechcourse.chat.repository.chat;

import hotechcourse.chat.entity.Chat;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatCustomRepository {

    @Query(value = "SELECT * FROM chat WHERE JSON_CONTAINS(participant, :id, '$')", nativeQuery = true)
    List<Chat> findChatList(@Param("id") String id);
}
