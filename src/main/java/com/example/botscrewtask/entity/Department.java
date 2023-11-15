package com.example.botscrewtask.entity;

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
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    private Lector headOfDepartment;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "departments_lectors",
            joinColumns = @JoinColumn(
                    name = "department_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "lector_id", referencedColumnName = "id"))
    private List<Lector> lectors;
}
