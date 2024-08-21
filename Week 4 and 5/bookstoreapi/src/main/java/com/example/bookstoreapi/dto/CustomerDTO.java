package com.example.bookstoreapi.dto;

import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class CustomerDTO extends RepresentationModel<CustomerDTO>{
    private Long id;

    private String name;

    private String email;

    @JsonProperty("phone") // Custom property name
    private String phoneNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // Custom date format
    private Date registeredDate;
}
