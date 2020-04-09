package ru.itis.almaz.jsonserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.almaz.jsonserver.model.Cabinet;

@Repository
public interface CabinetRepository extends JpaRepository<Cabinet, Long> {
}
