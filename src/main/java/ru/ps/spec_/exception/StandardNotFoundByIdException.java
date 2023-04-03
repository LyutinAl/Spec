package ru.ps.spec_.exception;

public class StandardNotFoundByIdException extends IllegalArgumentException{
    public StandardNotFoundByIdException(Long id) {
        super("Standard with id " + id + " not found");
    }
}
