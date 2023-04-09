package ru.ps.spec_.exception;

public class DictionaryIsEmptyException extends RuntimeException{
    public DictionaryIsEmptyException () {
        super("Dictionary is empty");
    }
}
