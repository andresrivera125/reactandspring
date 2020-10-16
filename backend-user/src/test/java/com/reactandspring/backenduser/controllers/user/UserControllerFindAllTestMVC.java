package com.reactandspring.backenduser.controllers.user;

import java.util.ArrayList;
import java.util.List;

import com.reactandspring.backenduser.controllers.UserController;
import com.reactandspring.backenduser.dtos.UserDTO;
import com.reactandspring.backenduser.services.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@WebMvcTest(UserController.class)
public class UserControllerFindAllTestMVC {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    IUserService service;

    @Autowired
    UserController controller;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        List<UserDTO> listExpected = new ArrayList<>();
        listExpected.add(UserDTO.of().id(1L).firstName("Person A").lastName("A").email("person-a@email.com").build());
        listExpected.add(UserDTO.of().id(2L).firstName("Person B").lastName("B").email("person-b@email.com").build());
        when(service.findAll()).thenReturn(listExpected);
    }

    @Test
    @DisplayName("Should return a list with information of two users")
    void should_return_a_list_with_three_users() throws Exception {
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/backend-user/users").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn();

        String result  = response.getResponse().getContentAsString();
        assertNotNull(result);
    }
}