package ru.ps.spec_.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ps.spec_.entity.StandardItem;
import ru.ps.spec_.service.StandardService;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/standards")
@CrossOrigin(origins = "*")
public class StandardController {

    private StandardService standardService;
    private ObjectMapper objectMapper;
    @PostMapping(value = "/getById/{id}")
    public ResponseEntity<StandardItem> getStandardById(@PathVariable Long id) throws JsonProcessingException {
        StandardItem standardItem = standardService.getStandardById(id);
        log.info("New query " + LocalDateTime.now() + " Get standard by id " + objectMapper.writeValueAsString(standardItem));
        return new ResponseEntity<>(standardItem, HttpStatus.OK);
    }

    @PostMapping(value = "/getByDictionaryId/{id}")
    public ResponseEntity<StandardItem> getStandardsByDictionaryId(@PathVariable Long id) throws JsonProcessingException {
        StandardItem standardItem = standardService.getStandardsByDictionaryId(id);
        log.info("New query " + LocalDateTime.now() + " Get standard by dictionary id " + objectMapper.writeValueAsString(standardItem));
        return new ResponseEntity<>(standardItem, HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public void saveStandard(@RequestBody StandardItem standardItem) throws JsonProcessingException {
        standardService.saveStandard(standardItem);
        log.info("New query " + LocalDateTime.now() + " Saved standard " + objectMapper.writeValueAsString(standardItem));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<StandardItem> updateStandard(@RequestBody StandardItem standardItem) throws JsonProcessingException {
        StandardItem updatedStandardItem = standardService.updateStandard(standardItem);
        log.info("New query " + LocalDateTime.now() + " Updated standard " + objectMapper.writeValueAsString(updatedStandardItem));
        return new ResponseEntity<>(updatedStandardItem, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStandardById(@PathVariable Long id) {
        standardService.deleteStandardById(id);
        log.info("New query " + LocalDateTime.now() + " Deleted standard with id " + id);
    }
}
