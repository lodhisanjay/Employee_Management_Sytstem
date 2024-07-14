package com.RegCURD.Controller;

import com.RegCURD.entity.Employee;
import com.RegCURD.service.EmpService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Controller
public class HomeController {
    @Autowired private EmpService service;

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
    public String empRegister(
            @ModelAttribute Employee employee, @RequestParam("img") MultipartFile img, Model model) {

        boolean isSaved = service.addEmpWithImage(employee, img);

        if (isSaved) {
            model.addAttribute("msg", "Employee Added Successfully..");
        } else {
            model.addAttribute("msg", "Failed to add employee.");
        }

        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model m) {
        Employee e = service.getEmpById(id);
        m.addAttribute("emp", e);
        return "edit";
    }

    @PostMapping("/update")
    public String update(
            @ModelAttribute Employee employee, @RequestParam("img") MultipartFile img, Model model) {
        boolean isUpdate = service.updateEmpWithImage(employee, img);

        if (isUpdate) {
            model.addAttribute("msg", "Employee Details Update Successfully..");
        } else {
            model.addAttribute("msg", "Failed to update employee details.");
        }

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id, HttpSession session) {
        service.deleteEmp(id);
        session.setAttribute("msg", "Emp Data delete Successfully..");
        return "redirect:/";
    }
}
