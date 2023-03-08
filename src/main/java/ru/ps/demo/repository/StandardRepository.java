package ru.ps.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ps.demo.entity.Standard;

@Repository
public interface StandardRepository extends JpaRepository<Standard, Long> {
    Standard findByItemCode();

}
