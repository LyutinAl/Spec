package ru.ps.spec_.service;

import ru.ps.spec_.entity.StandardItem;

import java.util.List;

public interface StandardService {

    public StandardItem getStandardById(Long id);

    public StandardItem getStandardsByDictionaryId(Long dictionaryId);

    public void saveStandard(StandardItem standardItem);

    public void deleteStandardById(Long id);

    public StandardItem updateStandard(StandardItem standardItem);
}
