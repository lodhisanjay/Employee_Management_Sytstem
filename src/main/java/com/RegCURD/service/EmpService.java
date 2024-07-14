package com.RegCURD.service;

import com.RegCURD.entity.Employee;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface EmpService {

    boolean addEmpWithImage(Employee employee, MultipartFile img);

    boolean updateEmpWithImage(Employee employee, MultipartFile img);

    Employee getEmpById(int id);

    void deleteEmp(int id);

    List<Employee> getAllEmp();
}
