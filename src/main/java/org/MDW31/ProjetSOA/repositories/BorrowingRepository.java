package org.MDW31.ProjetSOA.repositories;


import org.MDW31.ProjetSOA.entities.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
}