package com.armadillo.crm.controllers;

import com.armadillo.crm.entities.Company;
import com.armadillo.crm.entities.Customer;
import com.armadillo.crm.entities.enums.Gender;
import com.armadillo.crm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllUsers(){

         /* This is the test code. Will be replaced by real code
          that gets data from the database*/

        Customer customer = new Customer();
        customer.setFirstName("Vadim");
        customer.setLastName("Martsun");
        try {
            customer.setBirthDate(new SimpleDateFormat("yyyy-MM-dd").parse("1997-04-06"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        customer.setEmail("vadimmartsun@gmail.com");
        customer.setGender(Gender.MALE);
        customer.setId(1);
        customer.setPhoneNumber("063-395-02-04");

        Company company = new Company();
        company.setCompanyEmail("support@netpeaksoftware.com");
        company.setName("Netpeak Software");
        customer.setCompany(company);

        List<Customer> customers = new ArrayList<>();
        customers.add(customer);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customers", customers);
        modelAndView.setViewName("customerAll");

        return modelAndView;
    }


    @GetMapping(path = "/{id}")
    public ModelAndView getCustomer(@PathVariable String id) {
        Optional<Customer> customer = customerService.getCustomer(Integer.parseInt(id));

        Customer returnValue = new Customer();
        if (customer.isPresent()) {
            returnValue = customer.get();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customer", returnValue);
        modelAndView.setViewName("customer");

        return modelAndView;
    }


    @RequestMapping(value = "deleteCustomerPopUp/{customerId}", method = RequestMethod.GET)
    public String getDeleteCustomerPopUp(@PathVariable("customerId") int customerId){
        return "deleteCustomerPopUp";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView getAddCustomerPage(Model model){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customer", new Customer());
        modelAndView.setViewName("addCustomer");
        return modelAndView;
    }
}
