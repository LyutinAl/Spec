package ru.ps.demo.service;

import ru.ps.demo.dto.CatalogDto;

import java.util.List;

public interface CatalogService {
    List<CatalogDto> getAllCatalog();

    void saveElement(CatalogDto catalogDto);

    void updateElement(CatalogDto catalogDto);

    void deleteElement(Long elementId);

}
