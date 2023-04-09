package ru.ps.spec_.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@Table(name = "dictionary")
public class DictionaryElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "section_name")
    private String sectionName;

    @Column(name = "parent_id")
    private Long parentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private DictionaryElement parent;

    @JsonIgnore
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DictionaryElement> children = new ArrayList<>();

    @Column(name = "depth")
    private Integer depth;

    @Column(name = "is_standard", nullable = false)
    private Boolean isStandard;

    public DictionaryElement() {
        this.isStandard = false;
    }
}
