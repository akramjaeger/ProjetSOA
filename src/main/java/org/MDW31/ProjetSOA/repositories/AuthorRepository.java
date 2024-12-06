package org.MDW31.ProjetSOA.repositories;


import org.MDW31.ProjetSOA.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
