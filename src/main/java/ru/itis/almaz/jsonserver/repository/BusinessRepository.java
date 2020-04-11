package ru.itis.almaz.jsonserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.almaz.jsonserver.model.Business;
import ru.itis.almaz.jsonserver.model.Cabinet;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long> {

}