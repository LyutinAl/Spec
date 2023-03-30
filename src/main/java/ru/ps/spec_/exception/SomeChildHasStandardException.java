package ru.ps.spec_.exception;

public class SomeChildHasStandardException extends IllegalStateException{

    public SomeChildHasStandardException() {
        super("Some child elements are marked as standard, cannot perform cascade delete");
    }
}
