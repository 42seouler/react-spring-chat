package hotechcourse.chat.dto.chatmessage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageReadDto {

    private Long    id;
    private String  authorName;
    private String  content;
    private Long    timestamp;
}
