package com.dartnine.library.loan;

import com.dartnine.library.book.Book;
import com.dartnine.library.customer.Customer;

import java.time.LocalDate;

public class LoanDTO {
    private Customer customerDTO;
    private LocalDate beginDate;
    private LocalDate endDate;
    private LocalDate loanBeginDate;
    private LocalDate loanEndDate;
    private Book bookDTO;

    public Customer getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(Customer customerDTO) {
        this.customerDTO = customerDTO;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getLoanBeginDate() {
        return loanBeginDate;
    }

    public void setLoanBeginDate(LocalDate loanBeginDate) {
        this.loanBeginDate = loanBeginDate;
    }

    public LocalDate getLoanEndDate() {
        return loanEndDate;
    }

    public void setLoanEndDate(LocalDate loanEndDate) {
        this.loanEndDate = loanEndDate;
    }

    public Book getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(Book bookDTO) {
        this.bookDTO = bookDTO;
    }
}
