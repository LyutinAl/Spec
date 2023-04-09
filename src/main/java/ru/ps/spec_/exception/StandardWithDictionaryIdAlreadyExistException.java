package ru.ps.spec_.exception;

public class StandardWithDictionaryIdAlreadyExistException extends RuntimeException{

    public StandardWithDictionaryIdAlreadyExistException(Long id) {
        super("Element with dictionary_id:" + id + " already exist");
    }
}
