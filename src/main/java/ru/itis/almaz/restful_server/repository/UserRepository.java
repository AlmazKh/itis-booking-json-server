package ru.itis.almaz.restful_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.almaz.restful_server.model.Usr;

public interface UserRepository extends JpaRepository<Usr, Long> {
    Usr findUsrByEmail(String email);
}
