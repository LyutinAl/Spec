package ru.ps.spec_.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping(value = "/deleteBranch/{id}")
    public ResponseEntity<String> deleteBranchById(@PathVariable Long id) {
            dictionaryService.deleteIfAllChildrenNoIsStandard(id);
            return new ResponseEntity<>("Branch with id " + id + " deleted successfully", HttpStatus.OK);

    }
}
