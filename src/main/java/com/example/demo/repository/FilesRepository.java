package com.example.demo.repository;

import com.example.demo.domain.Files;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FilesRepository extends JpaRepository<Files, Long> {
    Page<Files> findAll(Pageable pageable);
}
