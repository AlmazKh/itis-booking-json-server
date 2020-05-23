package ru.itis.almaz.restful_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.almaz.restful_server.model.Cabinet;

@Repository
public interface CabinetRepository extends JpaRepository<Cabinet, Long> {

}
