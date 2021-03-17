package seouler.chatting.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.lang.reflect.Member;

@Entity
@Getter
@NoArgsConstructor
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long        id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User        author;
    @ManyToOne(fetch = FetchType.LAZY)
    private ChatRoom    chatRoom;
    private String      content;

    public ChatMessage(User author, ChatRoom chatRoom, String content) {
        this.author = author;
        this.chatRoom = chatRoom;
        this.content = content;
    }
}
