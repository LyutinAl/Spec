package ru.ps.spec_.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STANDARD_ITEMS")
public class StandardItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dictionary_id", unique = true)
    private Long dictionaryId;

    @Column(name = "catalog_code")
    private Long catalogCode;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "possible_of_using")
    private Boolean possibleOfUsing;

    @Column(name = "date_of_creation")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dateOfCreation;

    @Column(name = "date_of_update")
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date dateOfUpdate;
}
