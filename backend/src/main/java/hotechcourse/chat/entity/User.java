package hotechcourse.chat.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    private String  name;

    @Builder
    public User(String name) {
        this.name = name;
    }
}
