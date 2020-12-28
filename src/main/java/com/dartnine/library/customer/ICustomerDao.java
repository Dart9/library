package com.dartnine.library.customer;

import com.dartnine.library.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerDao extends JpaRepository<Customer, Integer>{

    public Customer findCustomerById(Integer customerId);

    public Customer findCustomerByEmail(String email);

    List<Customer> findCustomerByLastName(String lastName);

}

