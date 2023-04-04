package ru.ps.spec_.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ps.spec_.entity.StandardItem;
import ru.ps.spec_.exception.StandardNotFoundByDictionaryIdException;
import ru.ps.spec_.exception.StandardNotFoundByIdException;
import ru.ps.spec_.exception.StandardWithDictionaryIdAlreadyExistException;
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
        if (standardsRepository.existsById(id)) {
            standardsRepository.deleteById(id);
        } else {
            throw  new StandardNotFoundByIdException(id);
        }
    }

    @Override
    public void saveStandard(StandardItem standardItem) {
        if (!standardsRepository.existsByDictionaryId(standardItem.getDictionaryId())) {
            standardsRepository.save(standardItem);
        } else {
            throw new StandardWithDictionaryIdAlreadyExistException(standardItem.getDictionaryId());
        }

    }

    @Override
    public String updateStandard(StandardItem standardItem) {
        if (standardsRepository.existsById(standardItem.getId())) {
            standardsRepository.save(standardItem);
            return "Standard with id " + standardItem.getId() + " updated";
        }else {
            throw new StandardNotFoundByIdException(standardItem.getId());
        }
    }
}
