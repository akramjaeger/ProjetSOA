package org.MDW31.ProjetSOA.services;

import org.MDW31.ProjetSOA.entities.Borrowing;
import org.MDW31.ProjetSOA.repositories.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingService {
    @Autowired
    private BorrowingRepository borrowingRepository;

    public List<Borrowing> getAllBorrowings() {
        return borrowingRepository.findAll();
    }

    public Borrowing addBorrowing(Borrowing borrowing) {
        return borrowingRepository.save(borrowing);
    }
}

