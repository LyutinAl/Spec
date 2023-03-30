package ru.ps.spec_.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.ps.spec_.entity.DictionaryElement;
import ru.ps.spec_.service.DictionaryService;

import java.util.List;

@RestController
@AllArgsConstructor
public class DictionaryController {

    private DictionaryService dictionaryService;

    @PostMapping(value = "/getDictionaryContent")
    public List<DictionaryElement> getSortedDictionary() {
        return dictionaryService.getSortedElements();
    }

    @PostMapping(value = "/saveElement")
    public void saveElement(@RequestBody DictionaryElement dictionaryElement) {
        dictionaryService.saveDictionaryElement(dictionaryElement);
    }
}
