package com.praca.manager.controller;

import com.praca.manager.entity.Customer;
import com.praca.manager.entity.Details;
import com.praca.manager.service.CustomerService;
import com.praca.manager.service.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private DetailsService detailsService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {

        List<Customer> listCustomers = customerService.listAll();

        model.addAttribute("listCustomers", listCustomers);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewCustomerPage(Model model) {

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "new_customer";
    }

    @RequestMapping("/newdetail/{id}")
    public String showNewDetailPage(Model model, @PathVariable(name = "id") Integer id){

        Details details = new Details();

        details.setCustomer(customerService.getCustomer(id));

        model.addAttribute("details", details);

        return "new_details";
    }

    @RequestMapping("/select/{id}")
    public ModelAndView showSelectCustomerPage(@PathVariable(name = "id") Integer id){

        ModelAndView modelAndView = new ModelAndView("select_customer");

        Customer customerSelect = customerService.getCustomer(id);

        List<Details> detailsSelect = detailsService.findByCustomerId(id);

        modelAndView.addObject("customerSelect", customerSelect);

        modelAndView.addObject("detailsSelect", detailsSelect);

        return modelAndView;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.save(customer);

        return "redirect:/";
    }

    @RequestMapping(value ="/saveDetails", method = RequestMethod.POST)
    public String saveDetails(@ModelAttribute("details") Details details){
        detailsService.saveDetails(details);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Integer id) {

        ModelAndView modelAndView = new ModelAndView("edit_customer");

        Customer customer = customerService.getCustomer(id);

        modelAndView.addObject("customer", customer);

        return modelAndView;
    }

    @RequestMapping("/deletedetail/{id}")
    public String deleteDetail(@PathVariable(name = "id") Integer id){

        detailsService.deleteDetails(id);

        return "redirect:/select/{id}";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable(name = "id") Integer id) {

        customerService.delete(id);

        return "redirect:/";
    }

    @GetMapping("/find")
    public String findCustomerForm(Model model){

        Customer customer = new Customer();

        model.addAttribute("customerPhoneNumber", customer);

        return "find_customer";
    }

    @PostMapping("/find")
    public String findCustomerSubmit(@ModelAttribute Customer customer, Model model){

        model.addAttribute("customerPhoneNumber", customer);

        customer.setPhoneNumber(customer.getPhoneNumber());

        return "find_customer";
    }

    @PostMapping("/result")
    public String findCustomersByPhoneNumberEqualsTo(@ModelAttribute Customer customer, Model model){

        List<Customer> customers =
                customerService.findByPhoneNumberEqualsTo(customer.getPhoneNumber(), customer.getOwner());

        model.addAttribute("customerResult", customers);

        return "find_customer_result";
    }
}