package com.RegCURD.service;

import com.RegCURD.entity.Employee;
import com.RegCURD.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {
    private final EmpRepo repo;

    @Autowired
    public EmpServiceImpl(EmpRepo repo) {
        this.repo = repo;
    }

    public void addEmp(Employee employee) {
        repo.save(employee);
    }

    public List<Employee> getAllEmp() {
        return repo.findAll();
    }

    public Employee getEmpById(int id) {
        Optional<Employee> employee = repo.findById(id);
        return employee.orElse(null);
    }

    public void deleteEmp(int id) {
        repo.deleteById(id);
    }
}
