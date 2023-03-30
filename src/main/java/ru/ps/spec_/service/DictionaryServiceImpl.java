package ru.ps.spec_.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ps.spec_.entity.DictionaryElement;
import ru.ps.spec_.repository.DictionaryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DictionaryServiceImpl implements DictionaryService{

    private DictionaryRepository dictionaryRepository;

    @Override
    public List<DictionaryElement> getSortedElements() {
        return dictionaryRepository.findAllByOrderBySectionNameAscDepthAsc().get();
    }

    @Override
    public void saveDictionaryElement(DictionaryElement dictionaryElement) {
        dictionaryRepository.save(dictionaryElement);
    }
}
