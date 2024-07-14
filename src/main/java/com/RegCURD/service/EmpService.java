package com.RegCURD.service;

import com.RegCURD.entity.Employee;
import java.util.List;

public interface EmpService {

    void addEmp(Employee e);

    Employee getEmpById(int id);

    void deleteEmp(int id);

    List<Employee> getAllEmp();
}
