package com.dartnine.library.book;

import com.dartnine.library.category.CategoryDTO;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookDTO {

    private Integer id;
    private String title;
    private String isbn;
    private LocalDate releaseDate;
    private LocalDate registerDate;
    private Integer totalExamplaries;
    private String author;
    private CategoryDTO categoryDto;
}
