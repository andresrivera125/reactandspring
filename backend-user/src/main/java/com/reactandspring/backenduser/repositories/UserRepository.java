package com.reactandspring.backenduser.repositories;

import com.reactandspring.backenduser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
