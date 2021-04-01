package hotechcourse.chat.controller.user;

import hotechcourse.chat.dto.user.UserCreateDto;
import hotechcourse.chat.service.user.UserService;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserCreateController {

    private final UserService userService;

    @PostMapping("/api/v1/user")
    public Response createUser(@RequestBody @Valid UserCreateController.Request request) {
        Long userId = userService.createUser(convertToDto(request));
        return Response.builder()
                .id(userId)
                .build();
    }

    @Data
    @NoArgsConstructor
    public static class Request {

        private String name;

        public Request(String name) {
            this.name = name;
        }
    }

    @Data
    @NoArgsConstructor
    public static class Response {

        private Long id;

        @Builder
        public Response(Long id) {
            this.id = id;
        }
    }

    private UserCreateDto convertToDto(Request request) {
        return UserCreateDto.builder()
                .name(request.getName())
                .build();
    }
}
