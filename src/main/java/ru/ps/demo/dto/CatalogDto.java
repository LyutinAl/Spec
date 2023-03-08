package ru.ps.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatalogDto {

    private Long id;

    private Long sectionName;

    private Long parentId;

    private Integer depth;

    private Boolean isStandard;
}
