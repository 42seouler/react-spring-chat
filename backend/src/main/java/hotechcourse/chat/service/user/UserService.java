package hotechcourse.chat.service.user;

import hotechcourse.chat.dto.user.UserCreateDto;

public interface UserService {

    Long createUser(UserCreateDto dto);
}
