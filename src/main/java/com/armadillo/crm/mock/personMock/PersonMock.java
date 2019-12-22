package com.armadillo.crm.mock.personMock;

import com.armadillo.crm.entities.Customer;
import com.armadillo.crm.entities.Manager;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class PersonMock {

    private Random random = new Random();

    private String[] emails = {"@gmail.com", "@mail.ru", "@i.ua", "@yandex.ru"};

    public List<Customer> getRandomCustomers(int quantity){
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < quantity; i++){
            Customer customer = getRandomCustomer();
            customers.add(customer);
        }
        return customers;
    }

    public Customer getRandomCustomer(){
        Customer customer = new Customer();
        FirstNames firstNames = getRandomName();

        customer.setFirstName(firstNames.getName());
        customer.setLastName(getRandomLastName());
        customer.setGender(firstNames.getGender());
        customer.setEmail(Math.abs(random.nextInt(1000)) + emails[random.nextInt(emails.length)]);
        customer.setPhoneNumber(Math.abs(random.nextInt()) + "");
        //customer.setBirthDate(getRandomDate(1960,2000));

        return customer;
    }

    public Manager getRandomManager(){
        Manager manager = new Manager();
        FirstNames firstNames = getRandomName();

        manager.setFirstName(firstNames.getName());
        manager.setLastName(getRandomLastName());
        manager.setGender(firstNames.getGender());

        return manager;
    }

    private FirstNames getRandomName(){
        return (FirstNames.values())[random.nextInt(FirstNames.values().length)];
    }

    private String getRandomLastName(){
        return (LastNames.values())[random.nextInt(LastNames.values().length)].getLastName();
    }

    public LocalDate getRandomDate(int fromYear, int toYear){
        int year = random.nextInt(toYear - fromYear) + fromYear;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(27) + 1;

        return LocalDate.of(year,month,day);
    }
}
