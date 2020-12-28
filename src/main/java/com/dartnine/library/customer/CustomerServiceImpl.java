package com.dartnine.library.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerDao customerDao;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public Customer findCustomerByEmail(String email) {
        return customerDao.findCustomerByEmail(email);
    }

    @Override
    public boolean checkIfIdExists(Integer id) {
        return customerDao.existsById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerDao.deleteById(customerId);
    }

    @Override
    public List<Customer> findCustomerByLastName(String lastName) {
        return customerDao.findCustomerByLastName(lastName);
    }

    @Override
    public Customer findCustomerById(Integer customerId) {
        return customerDao.findCustomerById(customerId);
    }

    @Override
    public Page<Customer> getPaginatedCustomersList(int beginPage, int endPage) {
        return null;
    }
}
