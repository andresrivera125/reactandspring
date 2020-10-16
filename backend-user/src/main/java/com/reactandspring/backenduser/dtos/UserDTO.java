package com.reactandspring.backenduser.dtos;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.reactandspring.backenduser.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(builderMethodName = "of")
@AllArgsConstructor
@Getter
@Setter
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 2617054179285047301L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;

        UserDTO userDTO = (UserDTO) o;

        if (!getId().equals(userDTO.getId())) return false;
        if (!getFirstName().equals(userDTO.getFirstName())) return false;
        if (!getLastName().equals(userDTO.getLastName())) return false;
        return getEmail().equals(userDTO.getEmail());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public static boolean bothListAreEquals(List<UserDTO> listA, List<UserDTO> listB) {
        boolean result = true;
        for (int index = 0; index < listA.size(); index++) {
            if (!listA.get(index).equals(listB.get(index))) {
                result = false;
                break;
            }
        }

        return result;
    }

    public static List<UserDTO> mapToDTO(List<User> list) {
        return list.stream().map(UserDTO::new).collect(Collectors.toList());
    }
}
