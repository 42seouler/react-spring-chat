package seouler.chatting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seouler.chatting.entity.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}