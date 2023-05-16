package com.example.repository;

import com.example.entity.EmailHistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.time.LocalDate;
import java.util.List;

public interface EmailHistoryRepository extends CrudRepository<EmailHistoryEntity, Integer>, Repository<EmailHistoryEntity, Integer> {
    EmailHistoryEntity findByEmail(String email);

    List<EmailHistoryEntity> findByCreatedDate(LocalDate date);
}
