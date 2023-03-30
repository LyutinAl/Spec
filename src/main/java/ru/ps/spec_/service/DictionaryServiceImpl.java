package ru.ps.spec_.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ps.spec_.entity.DictionaryElement;
import ru.ps.spec_.exception.DictionaryElementNotFoundException;
import ru.ps.spec_.exception.SomeChildHasStandardException;
import ru.ps.spec_.repository.DictionaryRepository;

import java.nio.file.DirectoryIteratorException;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DictionaryServiceImpl implements DictionaryService{

    private DictionaryRepository dictionaryRepository;

    @Override
    public List<DictionaryElement> getSortedElements() {
        return dictionaryRepository.findAllByOrderByParentIdAscDepthAscSectionNameAsc()
                .orElseThrow(() -> new RuntimeException("Dictionary is empty"));
    }

    @Override
    public void saveDictionaryElement(DictionaryElement dictionaryElement) {
        dictionaryRepository.save(dictionaryElement);
    }

    @Override
    public void deleteIfAllChildrenNoIsStandard(Long id) {
        DictionaryElement dictionaryElement = dictionaryRepository.findById(id)
                .orElseThrow(() -> new DictionaryElementNotFoundException(id));
        if (allChildNoIsStandard(dictionaryElement.getChildren()) && !dictionaryElement.getIsStandard()) {
            dictionaryRepository.deleteById(id);
        } else {
            throw new SomeChildHasStandardException();
        }
    }

    private boolean allChildNoIsStandard(List<DictionaryElement> children) {
        for (DictionaryElement child:children) {
            if (child.getIsStandard()) {
                return false;
            }
            if (!allChildNoIsStandard(child.getChildren())) {
                return false;
            }
        }
        return true;
    }
}
