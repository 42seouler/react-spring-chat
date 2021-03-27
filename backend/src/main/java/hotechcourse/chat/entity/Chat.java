package hotechcourse.chat.entity;

import hotechcourse.chat.converter.ChatListConverter;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private Long    create_at;

    private Long    update_at;

    @Builder
    public Chat(List<Long> participant) {
        this.participant = participant;
        this.create_at = System.currentTimeMillis();
        this.update_at = System.currentTimeMillis();
    }
}
