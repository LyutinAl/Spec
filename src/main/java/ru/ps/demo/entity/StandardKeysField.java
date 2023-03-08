package ru.ps.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class StandardKeysField implements Serializable {
    @Column(name = "id")
    private Long id;

    @Column(name = "section_name")
    private Long sectionName;
}
