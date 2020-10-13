package com.zurum.learningcrud.repository;

import com.zurum.learningcrud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
