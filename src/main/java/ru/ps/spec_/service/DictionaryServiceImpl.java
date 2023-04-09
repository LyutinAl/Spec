package ru.ps.spec_.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ps.spec_.entity.DictionaryElement;
import ru.ps.spec_.exception.DictionaryElementNotFoundByParentIdException;
import ru.ps.spec_.exception.DictionaryElementNotFoundException;
import ru.ps.spec_.exception.DictionaryIsEmptyException;
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
                .orElseThrow(DictionaryIsEmptyException::new);
    }

    @Override
    public List<DictionaryElement> getRootElements() {
        return dictionaryRepository.findByParentIdIsNullOrderBySectionNameAsc()
                .orElseThrow(DictionaryIsEmptyException::new);
    }

    @Override
    public List<DictionaryElement> getByParentId(Long parentId) {
        return dictionaryRepository.findByParentIdOrderBySectionNameAsc(parentId)
                .orElseThrow(() -> new DictionaryElementNotFoundByParentIdException(parentId));
    }

    @Override
    public void saveDictionaryElement(DictionaryElement dictionaryElement) {
        dictionaryRepository.save(dictionaryElement);
    }

    @Override
    public String updateDictionaryElement(DictionaryElement dictionaryElement) {
        if (dictionaryRepository.existsById(dictionaryElement.getId())) {
            dictionaryRepository.save(dictionaryElement);
            return "Dictionary element with id " + dictionaryElement.getId() + " updated";
        }
        dictionaryRepository.save(dictionaryElement);
        return "Dictionary element with id " + dictionaryElement.getId() + " not exist and was created";
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

    /**
     * Function name: allChildNoIsStandard - function check all children of a dictionary element
     * @param children (List<DictionaryElement>)
     * @return (boolean)
     *     true - if all children of a dictionary element are not standard
     *     false - if at least one child of a dictionary element are standard
     */
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
