package hotechcourse.chat.dto.chatmessage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageCreateDto {

    private Long    chatId;
    private Long    authorId;
    private String  content;
    private Long    timestamp;
}





