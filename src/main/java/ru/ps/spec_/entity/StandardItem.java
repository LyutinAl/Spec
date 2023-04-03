package ru.ps.spec_.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "STANDARD_ITEMS")
public class StandardItem {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dictionary_id")
    private Long dictionaryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dictionary_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private DictionaryElement parent;

    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DictionaryElement> children = new ArrayList<>();

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
