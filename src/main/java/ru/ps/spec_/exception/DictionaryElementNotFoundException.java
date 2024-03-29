package ru.ps.spec_.exception;

public class DictionaryElementNotFoundException extends RuntimeException{
    public DictionaryElementNotFoundException(Long id) {
        super("Dictionary element with id:" + id + " not found");
    }
}
