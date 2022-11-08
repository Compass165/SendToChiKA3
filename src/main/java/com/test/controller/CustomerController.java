package com.test.controller;


import com.test.model.Customer;
import com.test.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public String getCustomers(Model model){
        List<Customer> customers = new ArrayList<>();
        customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "/customer/list";
    }

    @GetMapping("/{id}")
    public String getCustomerById(@PathVariable("id") int id, Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "/customer/detail";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("customer") Customer customer, Model model,BindingResult result){
        if (result.hasErrors()){
            System.out.println("Error!!!");
        }
        customerService.add(customer);
        model.addAttribute("customer", new Customer());
        return "/customer/create";
    }
}