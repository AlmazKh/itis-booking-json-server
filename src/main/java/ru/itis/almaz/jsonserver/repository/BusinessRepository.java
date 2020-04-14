package ru.itis.almaz.jsonserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.almaz.jsonserver.model.Business;

import java.util.List;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    @Query(value = "select b.id,\n" +
            "       b.date,\n" +
            "       b.status,\n" +
            "       b.time,\n" +
            "       b.cabinet_id,\n" +
            "       b.usr_id\n" +
            "from business b\n" +
            "         inner join cabinet c\n" +
            "                    on b.cabinet_id = c.id\n" +
            "                        and c.floor in :floors\n" +
            "                        and c.capacity = :capacity\n" +
            "         inner join usr u\n" +
            "                    on u.id = b.usr_id\n" +
            "                        and u.priority < :priority\n" +
            "where b.date = :date and b.time in :times\n" +
            "order by number, time;", nativeQuery = true)
    List<Business> findFreeTimesByDateAndAndCabinet_CapacityAndCabinet_Floor(
            @Param("date") String date,
            @Param("times") List<String> times,
            @Param("floors") List<Integer> floors,
            @Param("capacity") Integer capacity,
            @Param("priority") Integer priority
    );
}