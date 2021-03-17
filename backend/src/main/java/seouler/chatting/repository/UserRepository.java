package seouler.chatting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import seouler.chatting.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
