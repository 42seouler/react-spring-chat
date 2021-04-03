package hotechcourse.chat.repository.chat;

import hotechcourse.chat.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long>, ChatCustomRepository {

}

