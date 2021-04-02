package hotechcourse.chat.etc;

import hotechcourse.chat.entity.Chat;
import hotechcourse.chat.entity.ChatMessage;
import hotechcourse.chat.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    private static class InitService {

        private final EntityManager em;

        public void dbInit() {
            User userA = createUser("UserA");
            em.persist(userA);
            User userB = createUser("UserB");
            em.persist(userB);
            User userC = createUser("UserC");
            em.persist(userC);
            List<Long> userList = new ArrayList<>();
            userList.add(userA.getId());
            userList.add(userB.getId());
            Chat chat = createChat(userList);
            em.persist(chat);
            ChatMessage test_message = createChatMessage(chat, userA, "Test Message");
            for (int i = 0; i < 30; i++) {
                em.persist(test_message);
            }
        }

        private User createUser(String name) {
            return new User(name);
        }

        private Chat createChat(List<Long> userList) {
            return Chat.builder()
                    .name("TEST CHAT")
                    .participant(userList)
                    .build();
        }

        private ChatMessage createChatMessage(Chat chat, User author, String content) {
            return ChatMessage.builder()
                    .chat(chat)
                    .author(author)
                    .content(content)
                    .build();
        }
    }
}
