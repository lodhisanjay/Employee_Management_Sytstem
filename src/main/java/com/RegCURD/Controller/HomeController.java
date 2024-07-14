package com.RegCURD.Controller;

import com.RegCURD.entity.Employee;
import com.RegCURD.repository.EmpRepo;
import com.RegCURD.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private EmpService service;
    private EmpRepo repo;
    @Autowired
    public HomeController(EmpRepo repo) {
        this.repo = repo;
    }

    @GetMapping("/")
    public String home(Model m) {
        List<Employee> emp=service.getAllEmp();
        m.addAttribute("emp",emp);
        return "index";
    }

    @GetMapping("/addemp")
    public String addEmpForm() {
        return "addEmp";
    }

    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee employee, @RequestParam("img") MultipartFile img, Model model) {

        if (!img.isEmpty()) {
            try {
                employee.setProfile_pic(img.getOriginalFilename());
                Employee savedEmployee = repo.save(employee);

                if (savedEmployee != null) {
                    File saveFile = new ClassPathResource("static/images").getFile();
                    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
                    //System.out.println(path);//print the path of image
                    Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("msg", "Employee Added Successfully..");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        Employee e = service.getEmpById(id);
        m.addAttribute("emp", e);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Employee employee, @RequestParam("img") MultipartFile img,
                              HttpSession session, Model model) {
        if (!img.isEmpty()) {
            try {
                employee.setProfile_pic(img.getOriginalFilename());
                Employee savedEmployee = repo.save(employee);

                if (savedEmployee != null) {
                    File saveFile = new ClassPathResource("static/images").getFile();
                    Path path = Paths.get(saveFile.getAbsolutePath() + File.separator + img.getOriginalFilename());
                    Files.copy(img.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        model.addAttribute("msg", "Employee Data Update Successfully..");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session) {
        service.deleteEmp(id);
        session.setAttribute("msg", "Emp Data delete Successfully..");
        return "redirect:/";
    }
}
