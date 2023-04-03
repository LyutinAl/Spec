package ru.ps.spec_.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ps.spec_.entity.StandardItem;
import ru.ps.spec_.exception.StandardNotFoundByDictionaryIdException;
import ru.ps.spec_.exception.StandardNotFoundByIdException;
import ru.ps.spec_.repository.StandardsRepository;

@Service
@AllArgsConstructor
public class StandardServiceImpl implements StandardService {

    private StandardsRepository standardsRepository;

    @Override
    public StandardItem getStandardById(Long id) {
        return standardsRepository.findById(id)
                .orElseThrow(() -> new StandardNotFoundByIdException(id));
    }

    @Override
    public StandardItem getStandardsByDictionaryId(Long dictionaryId) {
        return standardsRepository.findByDictionaryId(dictionaryId)
                .orElseThrow(() -> new StandardNotFoundByDictionaryIdException(dictionaryId));
    }

    @Override
    public void deleteStandardById(Long id) {
        standardsRepository.deleteById(id);
    }

    @Override
    public void saveStandard(StandardItem standardItem) {
        standardsRepository.save(standardItem);
    }

    @Override
    public String updateStandard(StandardItem standardItem) {
        if (standardsRepository.existsById(standardItem.getId())) {
            standardsRepository.save(standardItem);
            return "Standard with id " + standardItem.getId() + " updated";
        }
        standardsRepository.save(standardItem);
        return "Standard with id " + standardItem.getId() + " not exist and was created";
    }
}
