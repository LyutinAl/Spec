package ru.ps.spec_.service;

import ru.ps.spec_.entity.DictionaryElement;

import java.util.List;

public interface DictionaryService {
    public List<DictionaryElement> getSortedElements();

    public List<DictionaryElement> getRootElements();

    public List<DictionaryElement> getByParentId(Long parentId);

    public void saveDictionaryElement(DictionaryElement dictionaryElement);

    public DictionaryElement updateDictionaryElement(DictionaryElement dictionaryElement);

    public void deleteIfAllChildrenNoIsStandard(Long id);
}
