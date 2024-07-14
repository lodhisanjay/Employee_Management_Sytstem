//package com.RegCURD.RestController;
//
//import com.RegCURD.entity.Employee;
//import com.RegCURD.repository.EmpRepo;
//import com.RegCURD.service.EmpService;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@Tag(name = "Employee Rest Api")
//@RequestMapping("/employee/v1")
//public class HomeRestController {
//    @Autowired
//    private EmpService service;
//    private EmpRepo repo;
//    @Autowired
//    public HomeRestController(EmpRepo repo) {
//        this.repo = repo;
//    }
//
//    @Operation(summary = "Post All User Details")
//    @PostMapping("/register")
//    public String empRegister(@ModelAttribute Employee e, HttpSession session) {
//        service.addEmp(e);
//        session.setAttribute("msg", "Employee Added Successfully..");
//        return "redirect:/";
//    }
//
//    @Operation(summary = "Update All User Details")
//    @PostMapping("/update")
//    public String update(@ModelAttribute Employee e, HttpSession session) {
//        service.addEmp(e);
//        session.setAttribute("msg", "Emp Data Update Successfully..");
//        return "redirect:/";
//    }
//
//    @Operation(summary = "Delete User Details by Employee Id")
//    @GetMapping("/delete/{id}")
//    public String deleteEmp(@PathVariable int id, HttpSession session) {
//        service.deleteEmp(id);
//        session.setAttribute("msg", "Emp Data delete Successfully..");
//        return "redirect:/";
//    }
//}
