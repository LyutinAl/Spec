package ru.ps.spec_.exception;

public class StandardNotFoundByDictionaryIdException extends RuntimeException{
    public StandardNotFoundByDictionaryIdException(Long id) {
        super("Standard with dictionary id " + id + " not found");
    }
}
