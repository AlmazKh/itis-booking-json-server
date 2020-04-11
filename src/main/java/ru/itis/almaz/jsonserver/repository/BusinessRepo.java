package ru.itis.almaz.jsonserver.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BusinessRepo {
    @Query(value = "SELECT * FROM cabinet cab JOIN ( " +
            "SELECT * FROM time_class t WHERE t.time NOT IN (" +
            "SELECT b.time FROM business b WHERE b.cabinet_id = t.cabinet_id AND b.date = :date)" +
            ") tc on tc.cabinet_id = cab.id", nativeQuery = true)
    List findFreeTimesByDate(@Param("date") String date);
}
