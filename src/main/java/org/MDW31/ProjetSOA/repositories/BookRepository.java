package org.MDW31.ProjetSOA.repositories;


import org.MDW31.ProjetSOA.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAvailable(boolean available);
}