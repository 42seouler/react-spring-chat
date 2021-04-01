package hotechcourse.chat.controller.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import hotechcourse.chat.controller.user.UserCreateController;
import hotechcourse.chat.dto.user.UserCreateDto;
import hotechcourse.chat.service.user.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebMvcTest(UserCreateController.class)
public class UserCreateControllerTest {

    @MockBean
    UserServiceImpl userService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void createUser() throws Exception {

        given(userService.createUser(any(UserCreateDto.class))).willReturn(1L);

        ObjectMapper objectMapper = new ObjectMapper();

        UserCreateController.Request seouler = new UserCreateController.Request("seouler");

        mockMvc.perform(post("/api/v1/user")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(seouler)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)));
    }

}
