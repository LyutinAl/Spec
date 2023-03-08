package ru.ps.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ps.demo.entity.CatalogElement;
import ru.ps.demo.entity.StandardKeysField;

import java.util.Optional;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogElement, Long> {
    Optional<CatalogElement> findById_Id(Long elementId);

}
