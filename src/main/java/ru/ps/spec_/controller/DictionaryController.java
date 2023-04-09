package ru.ps.spec_.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ps.spec_.entity.DictionaryElement;
import ru.ps.spec_.service.DictionaryService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Dictionary")
@CrossOrigin(origins = "*")
public class DictionaryController {

    private DictionaryService dictionaryService;

    @PostMapping(value = "/getContent")
    public List<DictionaryElement> getSortedDictionary() {
        return dictionaryService.getSortedElements();
    }

    @PostMapping(value = "/getRootContent")
    public List<DictionaryElement> getRootDictionary() {
        return dictionaryService.getRootElements();
    }

    @PostMapping(value = "/getByParentId/{id}")
    public List<DictionaryElement> getByParentId(@PathVariable Long id) {
        return dictionaryService.getByParentId(id);
    }

    @PostMapping(value = "/saveElement")
    public void saveElement(@RequestBody DictionaryElement dictionaryElement) {
        dictionaryService.saveDictionaryElement(dictionaryElement);
    }

    @PutMapping(value = "/updateElement")
    public ResponseEntity<String> updateElemnt(@RequestBody DictionaryElement dictionaryElement) {
        return new ResponseEntity<>(dictionaryService.updateDictionaryElement(dictionaryElement), HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteBranch/{id}")
    public ResponseEntity<String> deleteBranchById(@PathVariable Long id) {
            dictionaryService.deleteIfAllChildrenNoIsStandard(id);
            return new ResponseEntity<>("Branch with id " + id + " deleted successfully", HttpStatus.NO_CONTENT);

    }
}
