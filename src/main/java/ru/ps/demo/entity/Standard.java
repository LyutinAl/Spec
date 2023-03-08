package ru.ps.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STANDARDS")
public class Standard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_code")
    private Long itemCode;

    @Column(name = "dir_code")
    private String dirCode;

    @Column(name = "catalog_code")
    private Long catalogCode;

    @Column(name = "symbol")
    private String symbol;

    @Column(name = "possible_of_using")
    private Boolean possibleOfUsing;

    @Column(name = "date_of_creation")
    private Date dateOfCreation;

    @Column(name = "date_of_update")
    private Date dateOfUpdate;
}
