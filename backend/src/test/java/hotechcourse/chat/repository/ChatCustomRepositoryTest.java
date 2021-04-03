package hotechcourse.chat.repository;

import hotechcourse.chat.entity.Chat;
import hotechcourse.chat.entity.User;
import hotechcourse.chat.repository.chat.ChatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ChatCustomRepositoryTest {

    @Autowired
    private TestEntityManager tm;

    @Autowired
    private ChatRepository chatRepository;

    ArrayList<Long> userList = new ArrayList<>();

    @BeforeEach
    void setUP() {
        User seouler1 = tm.persist(User.builder().name("Seouler1").build());
        User seouler2 = tm.persist(User.builder().name("Seouler2").build());
        userList.add(seouler1.getId());
        userList.add(seouler2.getId());
    }

    @Test
    void readChat() {
        //given
        Chat test_chatroom = tm.persist(Chat.builder().name("TEST CHATROOM").participant(userList).build());
        //when
        List<Chat> chatList = chatRepository.findChatList("1");
        //then
        assertThat(test_chatroom.getName()).isEqualTo(chatList.get(0).getName());
    }
}
