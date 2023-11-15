package com.example.botscrewtask.repository;

import com.example.botscrewtask.entity.Department;
import com.example.botscrewtask.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("SELECT l.name FROM Lector l WHERE l.name LIKE %:part%")
    List<String> search(@Param("part")String part);
}
