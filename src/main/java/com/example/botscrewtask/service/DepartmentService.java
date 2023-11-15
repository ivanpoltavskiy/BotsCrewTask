package com.example.botscrewtask.service;

import com.example.botscrewtask.entity.Department;
import com.example.botscrewtask.entity.Lector;
import com.example.botscrewtask.enums.DegreeName;
import com.example.botscrewtask.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public String getHeadOfDepartment(String departmentName){
        Lector headOfDepartment = departmentRepository.findHeadOfDepartmentByDepartmentName(departmentName);

        if (!departmentRepository.existsDepartmentByName(departmentName)){
            return "There is no department";
        }
        return headOfDepartment == null ? "Department does not have a head" : "Head of " + departmentName + " department is " + headOfDepartment.getName();
    }

    public Map<DegreeName, Integer> getStat(String departmentName){
        Department department = departmentRepository.getDepartmentByName(departmentName);
        if (department == null){
            return Collections.emptyMap();
        }

        List<Lector> lectors = department.getLectors();
        Map<DegreeName, Integer> stat = new HashMap<>();

        for (Lector lector : lectors) {
            DegreeName degreeName = lector.getDegree();
            stat.put(degreeName, stat.getOrDefault(degreeName, 0) +1);
        }

        return stat;
    }

    public Double getAvgSalary(String departmentName){
        return departmentRepository.getAvgSalary(departmentName);
    }

    public Integer countLectors(String departmentName){
        return departmentRepository.countLectors(departmentName);
    }

    public List<String> search(String part){
        return departmentRepository.search(part);
    }
}
