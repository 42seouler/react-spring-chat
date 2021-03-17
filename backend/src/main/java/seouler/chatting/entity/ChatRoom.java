package seouler.chatting.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import seouler.chatting.converter.ChatRoomListConverter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Getter
@NoArgsConstructor
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Convert(converter = ChatRoomListConverter.class)
    @Column(columnDefinition = "json")
    private List<Long> participant;
    private String name;
    private Long create_at;
    private Long update_at;

    public ChatRoom(List<Long> participant, String name) {
        this.participant = participant;
        this.name = name;
        this.create_at = System.currentTimeMillis();
        this.update_at = System.currentTimeMillis();
    }
}
