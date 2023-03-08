package ru.ps.demo.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class StandardDto {

    private Long itemCode;

    private String dirCode;

    private Long catalogCode;

    private String symbol;

    private Boolean possibleOfUsing;

    @DateTimeFormat(pattern = "dd-MM-yyyy hh:mm:ss")
    private Date dateOfCreation;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dateOfUpdate;
}
