package ru.ps.spec_.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ps.spec_.entity.StandardItem;

import java.util.Optional;

@Repository
public interface StandardsRepository extends JpaRepository<StandardItem, Long> {
    Optional<StandardItem> findById(Long id);

    Optional<StandardItem> findByDictionaryElement(Long dictionaryId);
}
