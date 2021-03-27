package hotechcourse.chat.etc;

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
//            List<User> users = new ArrayList<>();
//            users.add(userA);
//            users.add(userB);
//            em.persist(new ChatRoom(users, "test"));
        }

        private User createUser(String name) {
            return new User(name);
        }
    }
}
