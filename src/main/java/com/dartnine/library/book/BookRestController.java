package com.dartnine.library.book;

import com.dartnine.library.customer.Customer;
import com.dartnine.library.customer.CustomerDTO;
import com.dartnine.library.customer.CustomerRestController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/rest/book/api")
public class BookRestController {

    public static final Logger LOGGER = LoggerFactory.getLogger(BookRestController.class);

    @Autowired
    private IBookService bookService;

    @PostMapping(value = "/addBook")
    @ApiOperation(value = "Add a new Book in the Library", response = BookDTO.class)
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Ok: the book already exist and add the total examplaries"),
            @ApiResponse(code = 201, message = "Created: the book is successfully inserted"),
            @ApiResponse(code = 304, message = "Not Modified: the book is unsuccessfully inserted") })
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTORequest){

        Book existingBook = bookService.findBookByIsbn(bookDTORequest.getIsbn());
        if (existingBook != null) {
            existingBook.setTotalExamplaries(existingBook.getTotalExamplaries()+1);
            return new ResponseEntity<BookDTO>(HttpStatus.OK);
        }
        Book bookRequest = mapBookDTOToBook(bookDTORequest);
        Book bookResponse = bookService.saveBook(bookRequest);
        if (bookResponse != null) {
            BookDTO bookDTO = mapBookToBookDTO(bookResponse);
            return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.CREATED);
        }
        return new ResponseEntity<BookDTO>(HttpStatus.NOT_MODIFIED);
    }

    /**
     * Transforme un entity Book en un POJO BookDTO
     *
     * @param book
     * @return
     */
    private BookDTO mapBookToBookDTO(Book book) {
        ModelMapper mapper = new ModelMapper();
        BookDTO bookDTO = mapper.map(book, BookDTO.class);
        return bookDTO;
    }

    /**
     * Transforme un POJO BookDTO en en entity Book
     *
     * @param bookDTO
     * @return
     */
    private Book mapBookDTOToBook(BookDTO bookDTO) {
        ModelMapper mapper = new ModelMapper();
        Book book = mapper.map(bookDTO, Book.class);
        return book;
    }
}
