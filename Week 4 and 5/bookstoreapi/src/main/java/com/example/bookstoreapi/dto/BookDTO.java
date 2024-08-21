package com.example.bookstoreapi.dto;

import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BookDTO extends RepresentationModel<BookDTO>{
    private Long id;

    @JsonProperty("book_title") // Custom property name
    private String title;

    private String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "$#.00") // Custom format for price
    private Double price;

    private String isbn;
}
