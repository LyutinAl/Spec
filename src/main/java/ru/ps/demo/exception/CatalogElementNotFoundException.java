package ru.ps.demo.exception;

import ru.ps.demo.entity.StandardKeysField;

public class CatalogElementNotFoundException extends RuntimeException {

    public CatalogElementNotFoundException(Long id) {
        super("Catalog element id: " + id + "not found");
    }
}
