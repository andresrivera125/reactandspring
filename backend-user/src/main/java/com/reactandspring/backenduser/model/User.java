package com.reactandspring.backenduser.model;

import javax.persistence.*;

import java.io.Serializable;

import lombok.*;

@Entity
@Table(name = "users")
@Builder(builderMethodName = "of")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = -4280528458984502385L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;
}
