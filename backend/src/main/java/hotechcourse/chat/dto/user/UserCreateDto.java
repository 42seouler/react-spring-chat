package hotechcourse.chat.dto.user;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCreateDto {

    private String name;

    @Builder
    public UserCreateDto(String name) {
        this.name = name;
    }
}
