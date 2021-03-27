package hotechcourse.chat.repository;

import hotechcourse.chat.entity.Chat;
import hotechcourse.chat.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ChatRepositoryTest {

    @Autowired
    private TestEntityManager tm;

    @Autowired
    private ChatRepository chatRepository;

    ArrayList<Long> userList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        User seouler1 = tm.persist(User.builder().name("Seouler1").build());
        User seouler2 = tm.persist(User.builder().name("Seouler2").build());
        userList.add(seouler1.getId());
        userList.add(seouler2.getId());
    }

    @Test
    void createChat() {
        //given
        Chat chat = Chat.builder().participant(userList).build();
        tm.persist(chat);
        //when
        Chat findChat = chatRepository.findById(chat.getId()).orElseThrow();
        //then
        assertThat(chat.getId()).isEqualTo(findChat.getId());
    }
}