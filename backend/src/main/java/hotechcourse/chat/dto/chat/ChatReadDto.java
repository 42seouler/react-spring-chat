package hotechcourse.chat.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatReadDto {

    private Long    id;
    private String  name;
    private Long    update_at;
}
