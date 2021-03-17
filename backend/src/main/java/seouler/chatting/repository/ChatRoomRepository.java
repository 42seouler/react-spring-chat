package seouler.chatting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seouler.chatting.entity.ChatRoom;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {
}
