package hotechcourse.chat.entity;

import hotechcourse.chat.converter.ChatListConverter;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;

    @Convert(converter = ChatListConverter.class)
    @Column(columnDefinition = "json")
    private List<Long> participant = new ArrayList<>();

    private String  name;

    private Long    create_at;

    private Long    update_at;

    @Builder
    public Chat(String name, List<Long> participant) {
        this.name = name;
        this.participant = participant;
        this.create_at = System.currentTimeMillis();
        this.update_at = System.currentTimeMillis();
    }

    @Builder
    public Chat(Long id, List<Long> participant, String name, Long create_at, Long update_at) {
        this.id = id;
        this.participant = participant;
        this.name = name;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "id=" + id +
                ", participant=" + participant +
                ", name='" + name + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}
