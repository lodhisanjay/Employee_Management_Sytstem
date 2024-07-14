package com.RegCURD.repository;

import com.RegCURD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer>{

}
