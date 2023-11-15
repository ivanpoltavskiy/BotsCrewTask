package com.example.botscrewtask.controller;

import com.example.botscrewtask.entity.Department;
import com.example.botscrewtask.entity.Lector;
import com.example.botscrewtask.repository.LectorRepository;
import com.example.botscrewtask.service.LectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lector")
public class LectorController {
    private final LectorService lectorService;

    @GetMapping("/search/{part}")
    public List<String> search(@PathVariable String part){
        return lectorService.search(part);
    }
}
