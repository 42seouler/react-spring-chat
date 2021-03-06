package hotechcourse.chat.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long    id;
    @ManyToOne(fetch = FetchType.LAZY)
    Chat    chat;
    @ManyToOne(fetch = FetchType.LAZY)
    User    author;
    String  content;
    Long    timestamp;

    @Builder
    public ChatMessage(Chat chat, User author, String content) {
        this.chat = chat;
        this.author = author;
        this.content = content;
        this.timestamp = System.currentTimeMillis();
    }
}
