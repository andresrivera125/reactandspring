package com.reactandspring.backenduser.controllers.user;

import java.util.ArrayList;
import java.util.List;

import com.reactandspring.backenduser.controllers.UserController;
import com.reactandspring.backenduser.dtos.UserDTO;
import com.reactandspring.backenduser.services.IUserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserControllerFindAllTest {

    @Mock
    IUserService service;

    @InjectMocks
    UserController controller = new UserController();

    @Test
    @DisplayName("Should return a list with information of three people")
    void should_return_a_list_with_three_people() {
        int sizeExpected = 2;

        List<UserDTO> listExpected = new ArrayList<>();
        listExpected.add(UserDTO.of().id(1L).firstName("Person A").lastName("A").email("person-a@email.com").build());
        listExpected.add(UserDTO.of().id(2L).firstName("Person B").lastName("B").email("person-b@email.com").build());
        when(service.findAll()).thenReturn(listExpected);

        List<UserDTO> listReturn = controller.findAll();

        assertNotNull(listReturn);
        assertEquals(sizeExpected, listReturn.size(), "It must have 3 elements");
        assertIterableEquals( listReturn, listExpected, "Both list must be equals");
    }
}
