package com.dartnine.library.customer;

import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface ICustomerService {
    public Customer saveCustomer(Customer customerRequest) ;

    public Customer findCustomerByEmail(String email) ;

    boolean checkIfIdExists(Integer id);

    Customer updateCustomer(Customer customerRequest);

    void deleteCustomer(Integer customerId);

    List<Customer> findCustomerByLastName(String lastName);

    Customer findCustomerById(Integer customerId);

    Page<Customer> getPaginatedCustomersList(int beginPage, int endPage);
}
