package hotechcourse.chat.service.user;

import hotechcourse.chat.dto.user.UserCreateDto;
import hotechcourse.chat.entity.User;
import hotechcourse.chat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Long createUser(UserCreateDto dto) {
        return userRepository.save(User.builder()
                .name(dto.getName())
                .build())
                .getId();
    }
}
