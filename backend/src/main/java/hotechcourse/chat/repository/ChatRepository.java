package hotechcourse.chat.repository;

import hotechcourse.chat.entity.Chat;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Long>, ChatCustomRepository {

}

