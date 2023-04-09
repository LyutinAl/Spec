package ru.ps.spec_.exception;

public class DictionaryElementNotFoundByParentIdException extends IllegalArgumentException{
    public DictionaryElementNotFoundByParentIdException(Long id) {
        super("Dictionary elements with parent id: " + id + " not found");
    }
}
