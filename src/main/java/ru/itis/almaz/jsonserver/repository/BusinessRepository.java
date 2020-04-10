package ru.itis.almaz.jsonserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.almaz.jsonserver.model.Business;
import ru.itis.almaz.jsonserver.model.Cabinet;

public interface BusinessRepository  extends JpaRepository<Business, Long> {

}