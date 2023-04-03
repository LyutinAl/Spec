package ru.ps.spec_.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ps.spec_.entity.StandardItem;
import ru.ps.spec_.service.StandardService;

@RestController
@AllArgsConstructor
@RequestMapping("/standards")
public class StandardController {

    private StandardService standardService;

    @PostMapping(value = "/getBiId/{id}")
    public ResponseEntity<StandardItem> getStandardById(@PathVariable Long id) {
        standardService.getStandardById(id);
        return new ResponseEntity<>(standardService.getStandardById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/getByDictionaryId/{id}")
    public ResponseEntity<StandardItem> getStandardsByDictionaryId(@PathVariable Long id) {
        return new ResponseEntity<>(standardService.getStandardsByDictionaryId(id), HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public void saveStandard(@RequestBody StandardItem standardItem) {
        standardService.saveStandard(standardItem);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStandardById(@PathVariable Long id) {
        standardService.deleteStandardById(id);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<String> updateStandard(@RequestBody StandardItem standardItem) {
        return new ResponseEntity<>(standardService.updateStandard(standardItem), HttpStatus.OK);
    }
}
