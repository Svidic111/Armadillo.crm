package com.armadillo.crm.controllers;

import com.armadillo.crm.entities.Company;
import com.armadillo.crm.entities.Customer;
import com.armadillo.crm.entities.enums.Gender;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getAllUsers(){
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
        modelAndView.addObject("customers",customers);
        modelAndView.setViewName("customerAll");

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "deleteCustomerPopUp/{customerId}")
    public String getDeleteCustomerPopUp(@PathVariable("customerId") int customerId){
        return "deleteCustomerPopUp";
    }
}