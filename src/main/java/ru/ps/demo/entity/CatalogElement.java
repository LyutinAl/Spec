package ru.ps.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CATALOG")
public class CatalogElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "section_name")
    private Long sectionName;

    @Column(name = "parent_id")
    private Long parentId;

    @Column(name = "depth")
    private Integer depth;

    @Column(name = "is_standard")
    private Boolean isStandard;
}
