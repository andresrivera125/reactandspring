package com.reactandspring.backenduser.services.user;

import java.util.ArrayList;
import java.util.List;

import com.reactandspring.backenduser.dtos.UserDTO;
import com.reactandspring.backenduser.model.User;
import com.reactandspring.backenduser.repositories.UserRepository;
import com.reactandspring.backenduser.services.IUserService;
import com.reactandspring.backenduser.services.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceFindAllTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    IUserService service = new UserService();

    @Test
    @DisplayName("Should return a list with information of three users")
    void should_return_a_list_with_three_users() {
        List<UserDTO> listReturn;
        int sizeExpected = 3;
        List<User> listExpected = new ArrayList<>();
        listExpected.add(User.of().id(1L).firstName("Person A").lastName("A").email("person-a@email.com").build());
        listExpected.add(User.of().id(2L).firstName("Person B").lastName("B").email("person-b@email.com").build());
        listExpected.add(User.of().id(3L).firstName("Person C").lastName("C").email("person-c@email.com").build());

        when(repository.findAll()).thenReturn(listExpected);

        listReturn = service.findAll();

        assertNotNull(listReturn);
        assertEquals(sizeExpected, listReturn.size(), "It must have 3 elements");
        assertTrue(UserDTO.bothListAreEquals(listReturn, UserDTO.mapToDTO(listExpected)), "Both list must be equals");
    }
}