package ru.ps.spec_.exception;

public class StandardNotFoundByDictionaryIdException extends IllegalArgumentException{
    public StandardNotFoundByDictionaryIdException(Long id) {
        super("Standard with dictionary id " + id + " not found");
    }
}
