package org.MDW31.ProjetSOA.repositories;


import org.MDW31.ProjetSOA.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

