package com.RegCURD.service;

import com.RegCURD.entity.Employee;
import com.RegCURD.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired private EmpRepo repo;

    public boolean addEmpWithImage(Employee employee, MultipartFile img) {
        if (!img.isEmpty()) {
            try {
                employee.setProfile_pic(img.getOriginalFilename());
                Employee savedEmployee = repo.save(employee);

                if (savedEmployee != null) {
                    File saveFile = new ClassPathResource("static/images").getFile();
                    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
                    Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean updateEmpWithImage(Employee employee, MultipartFile img) {
        try {
            if (img != null && !img.isEmpty()) {
                employee.setProfile_pic(img.getOriginalFilename());
                File saveFile = new ClassPathResource("static/images").getFile();
                Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
                Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            }

            Employee savedEmployee = repo.save(employee);
            return savedEmployee != null;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
