package ru.ps.spec_.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ps.spec_.entity.DictionaryElement;

import java.util.List;
import java.util.Optional;

@Repository
public interface DictionaryRepository extends JpaRepository<DictionaryElement, Long> {
    Optional<List<DictionaryElement>> findAllByOrderByParentIdAscDepthAscSectionNameAsc();
}
