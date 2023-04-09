package ru.ps.spec_.exception;

public class DictionaryIsEmptyException extends IllegalArgumentException{
    public DictionaryIsEmptyException () {
        super("Dictionary is empty");
    }
}
