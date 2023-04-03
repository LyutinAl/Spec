package ru.ps.spec_.service;

import ru.ps.spec_.entity.DictionaryElement;

import java.util.List;

public interface DictionaryService {
    public List<DictionaryElement> getSortedElements();

    public void saveDictionaryElement(DictionaryElement dictionaryElement);

    public String updateDictionaryElement(DictionaryElement dictionaryElement);

    public void deleteIfAllChildrenNoIsStandard(Long id);
}
