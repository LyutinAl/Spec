package ru.ps.spec_.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ps.spec_.entity.DictionaryElement;
import ru.ps.spec_.service.DictionaryService;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/Dictionary")
@CrossOrigin(origins = "*")
public class DictionaryController {

    private DictionaryService dictionaryService;
    private ObjectMapper objectMapper;

    @PostMapping(value = "/getContent")
    public List<DictionaryElement> getSortedDictionary() throws JsonProcessingException {
        List<DictionaryElement> dictionaryElements = dictionaryService.getSortedElements();
        log.info("New query " + LocalDateTime.now() + "Get sorted dictionary " + objectMapper.writeValueAsString(dictionaryElements));
        return dictionaryElements;
    }

    @PostMapping(value = "/getRootContent")
    public List<DictionaryElement> getRootDictionary() throws JsonProcessingException {
        List<DictionaryElement> dictionaryElements = dictionaryService.getRootElements();
        log.info("New query " + LocalDateTime.now() + "Get root dictionary " + objectMapper.writeValueAsString(dictionaryElements));
        return dictionaryElements;
    }

    @PostMapping(value = "/getByParentId/{id}")
    public List<DictionaryElement> getByParentId(@PathVariable Long id) throws JsonProcessingException {
        List<DictionaryElement> dictionaryElements = dictionaryService.getByParentId(id);
        log.info("New query " + LocalDateTime.now() + " Get dictionary by parent id " + objectMapper.writeValueAsString(dictionaryElements));
        return dictionaryService.getByParentId(id);
    }

    @PostMapping(value = "/saveElement")
    public void saveElement(@RequestBody DictionaryElement dictionaryElement) throws JsonProcessingException {
        dictionaryService.saveDictionaryElement(dictionaryElement);
        log.info("New query " + LocalDateTime.now() + " Saved dictionary element " + objectMapper.writeValueAsString(dictionaryElement));
    }

    @PutMapping(value = "/updateElement")
    public ResponseEntity<DictionaryElement> updateElement(@RequestBody DictionaryElement dictionaryElement) throws JsonProcessingException {
        DictionaryElement updateDictionaryElement =  dictionaryService.updateDictionaryElement(dictionaryElement);
        log.info("New query " + LocalDateTime.now() + " Updated dictionary element " + objectMapper.writeValueAsString(updateDictionaryElement));
        return new ResponseEntity<>(updateDictionaryElement, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deleteBranch/{id}")
    public HttpStatus deleteBranchById(@PathVariable Long id) {
            dictionaryService.deleteIfAllChildrenNoIsStandard(id);
            log.info("New query " + LocalDateTime.now() + " Deleted branch with id " + id);
            return HttpStatus.NO_CONTENT;

    }
}
