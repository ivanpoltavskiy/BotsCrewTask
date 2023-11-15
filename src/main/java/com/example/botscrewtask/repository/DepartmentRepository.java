package com.example.botscrewtask.repository;

import com.example.botscrewtask.entity.Department;
import com.example.botscrewtask.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Boolean existsDepartmentByName(String departmentName);

    @Query("SELECT d.headOfDepartment FROM Department d WHERE d.name = :departmentName")
    Lector findHeadOfDepartmentByDepartmentName(@Param("departmentName") String departmentName);

    Department getDepartmentByName(String departmentName);

    @Query("SELECT AVG(l.salary) FROM Department d " +
            "JOIN d.lectors l " +
            "WHERE d.name = :departmentName")
    Double getAvgSalary(@Param("departmentName") String departmentName);

    @Query("SELECT COUNT(l) FROM Department d " +
            "JOIN d.lectors l " +
            "WHERE d.name = :departmentName")
    Integer countLectors(@Param("departmentName") String departmentName);

    @Query("SELECT d.name FROM Department d WHERE d.name LIKE %:part%")
    List<String> search(@Param("part")String part);
}
