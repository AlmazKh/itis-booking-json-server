package ru.itis.almaz.jsonserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.almaz.jsonserver.model.Usr;

public interface UserRepository extends JpaRepository<Usr, Long> {
    Usr findUsrByEmail(String email);
}
