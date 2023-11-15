package com.example.botscrewtask.entity;

import com.example.botscrewtask.enums.DegreeName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Lector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private DegreeName degree;
    private Double salary;

    @OneToOne
    private Department headedDepartment;

    @ManyToMany(mappedBy = "lectors")
    private List<Department> departments;
}
