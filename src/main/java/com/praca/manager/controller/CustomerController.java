package com.praca.manager.controller;

import com.itextpdf.text.DocumentException;
import com.praca.manager.entity.Customer;
import com.praca.manager.entity.Details;
import com.praca.manager.repository.CustomerRepository;
import com.praca.manager.service.CustomerService;
import com.praca.manager.service.DetailsService;
import com.praca.manager.service.PdfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class CustomerController {

    private PdfService pdfService;
    private CustomerService customerService;
    private DetailsService detailsService;
    private CustomerRepository customerRepository;

    public CustomerController(DetailsService detailsService,
                              CustomerService customerService,
                              PdfService pdfService,
                              CustomerRepository customerRepository){
        this.detailsService = detailsService;
        this.customerService = customerService;
        this.pdfService = pdfService;
        this.customerRepository = customerRepository;
    }

    @RequestMapping("/")
    public String viewHomePage(Model model){

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

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateCustomer(@PathVariable(name = "id") Integer id,
                                 @ModelAttribute("customer") Customer customer){
        //System.out.println(id);
        //customer.setCustomerId(id);
        System.out.println("____________________");
        System.out.println("customer id " + customer.getCustomerId());
        System.out.println("____________________");
        customer.setCustomerId(id);
        System.out.println("customer id " + customer.getCustomerId());
        System.out.println("owner " + customer.getOwner());
        System.out.println("address " + customer.getAddress());
        System.out.println("phone number " + customer.getAddress());
        System.out.println("to string: " + customer.toString());
        System.out.println("id " + id);
        customerService.save(customer);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") Integer id, Model model) {

        ModelAndView modelAndView = new ModelAndView("edit_customer");

        Customer customer = customerService.getCustomer(id);
        //Customer customer = customerRepository.getOne(id);
        //customer.setCustomerId(customerRepository.getOne(id).getCustomerId());
        System.out.println(customer.getCustomerId());
        System.out.println(customer.toString());
        model.addAttribute("customer", customer);
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

    @RequestMapping("/print/{id}")
    public String customerToPdf(@PathVariable(name = "id") Integer id) throws FileNotFoundException, DocumentException {

        pdfService.newDocument(id);

        return "redirect:/";
    }
}