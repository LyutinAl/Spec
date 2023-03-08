package ru.ps.demo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ps.demo.dto.CatalogDto;
import ru.ps.demo.entity.CatalogElement;
import ru.ps.demo.exception.CatalogElementNotFoundException;
import ru.ps.demo.repository.CatalogRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService{

    private CatalogRepository catalogRepository;

    @Override
    public List<CatalogDto> getAllCatalog() {
        return catalogRepository.findAll()
                .stream()
                .map(this::mapToCatalogDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveElement(CatalogDto catalogDto) {
        CatalogElement catalogElement = mapToCatalog(catalogDto);
        catalogRepository.save(catalogElement);
    }

    @Override
    public void updateElement(CatalogDto catalogDto) {
        CatalogElement catalogElement = mapToCatalog(catalogDto);
        Optional<CatalogElement> element = catalogRepository.findById_Id(catalogElement.getId());
        if (element.isPresent()) {
            catalogRepository.save(catalogElement);
        } else {
            throw new CatalogElementNotFoundException(catalogElement.getId());
        }
    }

    @Override
    public void deleteElement(Long elementId) {
        catalogRepository.deleteById(elementId);
    }

    private CatalogDto mapToCatalogDto(CatalogElement catalogElement) {
        CatalogDto catalogDto = new CatalogDto();
        catalogDto.setId(catalogElement.getId());
        catalogDto.setSectionName(catalogElement.getSectionName());
        catalogDto.setParentId(catalogElement.getParentId());
        catalogDto.setDepth(catalogElement.getDepth());
        catalogDto.setIsStandard(catalogElement.getIsStandard());
        return catalogDto;
    }

    private CatalogElement mapToCatalog(CatalogDto catalogDto) {
        CatalogElement catalogElement = new CatalogElement();
        catalogElement.setId(catalogDto.getId());
        catalogElement.setSectionName(catalogDto.getSectionName());
        catalogElement.setParentId(catalogDto.getParentId());
        catalogElement.setDepth(catalogDto.getDepth());
        catalogElement.setIsStandard(catalogDto.getIsStandard());
        return catalogElement;
    }
}
