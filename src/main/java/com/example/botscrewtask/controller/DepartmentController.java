package com.example.botscrewtask.controller;

import com.example.botscrewtask.entity.Department;
import com.example.botscrewtask.enums.DegreeName;
import com.example.botscrewtask.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/{departmentName}")
    public String getHeadOfDepartment(@PathVariable String departmentName){
        return departmentService.getHeadOfDepartment(departmentName);
    }

    @GetMapping("/stat/{departmentName}")
    public Map<DegreeName, Integer> getStat(@PathVariable String departmentName){
        return departmentService.getStat(departmentName);
    }

    @GetMapping("/salary/{departmentName}")
    public Double getAvgSalary(@PathVariable String departmentName){
        return departmentService.getAvgSalary(departmentName);
    }

    @GetMapping("/lectors/{departmentName}")
    public Integer countLectors(@PathVariable String departmentName){
        return departmentService.countLectors(departmentName);
    }
    /**
     * If you work with Postman, it is better to use @RequestParam, but now easier to use @PathVariable
     */
    @GetMapping("/search/{part}")
    public List<String> search(@PathVariable String part){
        return departmentService.search(part);
    }
}
