package ru.itis.almaz.jsonserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.almaz.jsonserver.model.Cabinet;
import ru.itis.almaz.jsonserver.model.FreeTime;

import java.util.List;

public interface FreeTimeRepository extends JpaRepository<FreeTime, Long> {
    @Query(value = "SELECT * FROM free_time t WHERE t.time NOT IN" +
            "(SELECT b.time FROM business b WHERE b.cabinet_id = t.cabinet_id AND b.date = :date )", nativeQuery = true)
    List<FreeTime> findFreeTimesByDate(@Param("date") String date);
}
