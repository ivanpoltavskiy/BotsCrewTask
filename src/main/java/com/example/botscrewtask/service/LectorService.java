package com.example.botscrewtask.service;

import com.example.botscrewtask.entity.Department;
import com.example.botscrewtask.entity.Lector;
import com.example.botscrewtask.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectorService {

    private final LectorRepository lectorRepository;

    public List<String> search(String part){
        return lectorRepository.search(part);
    }
}
