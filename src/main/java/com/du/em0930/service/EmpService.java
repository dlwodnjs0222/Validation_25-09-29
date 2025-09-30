package com.du.em0930.service;

import com.du.em0930.entity.Emp;
import com.du.em0930.repository.EmpRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class EmpService {

    private final EmpRepository empRepository;

    public void save(Emp emp) {
        empRepository.save(emp);
    }

    public Emp findById(long id) {
        return empRepository.findById(id);
    }

    public List<Emp> findAll() {
        return empRepository.findAll();
    }

    public void update(Emp emp) {
        empRepository.update(emp);
    }

    public void delete(long id) {
        empRepository.delete(id);
    }
}
