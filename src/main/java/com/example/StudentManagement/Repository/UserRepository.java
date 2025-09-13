package com.example.StudentManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.StudentManagement.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findById(Integer id);

	Optional<User> findByEmail(String email);

}
