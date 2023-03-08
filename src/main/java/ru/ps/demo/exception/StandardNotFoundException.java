package ru.ps.demo.exception;

import ru.ps.demo.entity.Standard;

public class StandardNotFoundException extends RuntimeException{
    public StandardNotFoundException(Standard standard) {
        super("Standard element item code: " + standard.getItemCode() + "not found");
    }
}
