package hotechcourse.chat.entity;


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
    User    author;
    String  content;
    @ManyToOne(fetch = FetchType.LAZY)
    Chat    chat;
    Long    timestamp;

    public ChatMessage(User author, String content, Chat chat)  {
        this.author = author;
        this.content = content;
        this.chat = chat;
        this.timestamp = System.currentTimeMillis();
    }
}
