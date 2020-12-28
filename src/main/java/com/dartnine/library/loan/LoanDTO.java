package com.dartnine.library.loan;

import com.dartnine.library.book.Book;
import com.dartnine.library.customer.Customer;
import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanDTO {
    private Customer customerDTO;
    private LocalDate beginDate;
    private LocalDate endDate;
    private LocalDate loanBeginDate;
    private LocalDate loanEndDate;
    private Book bookDTO;
}
