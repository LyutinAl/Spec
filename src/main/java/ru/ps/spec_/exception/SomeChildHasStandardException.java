package ru.ps.spec_.exception;

public class SomeChildHasStandardException extends RuntimeException{

    public SomeChildHasStandardException() {
        super("Some child elements are marked as standard, cannot perform cascade delete");
    }
}
