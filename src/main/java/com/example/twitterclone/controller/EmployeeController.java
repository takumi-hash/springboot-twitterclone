package com.example.twitterclone.controller;
import java.util.List;

import com.example.twitterclone.domain.Employee;
import com.example.twitterclone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository empRepository;
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public String index(Model model) {
        List<Employee> emplist=empRepository.findAll();
        model.addAttribute("emplist", emplist);
        return "emp";
    }
}
