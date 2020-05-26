package ru.itis.almaz.restful_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.almaz.restful_server.model.FreeTime;

import java.util.List;

public interface FreeTimeRepository extends JpaRepository<FreeTime, Long> {
    @Query(value = "SELECT * FROM free_time t WHERE t.time NOT IN" +
            "(SELECT b.time FROM business b WHERE b.cabinet_id = t.cabinet_id AND b.date = :date )", nativeQuery = true)
    List<FreeTime> findFreeTimesByDate(@Param("date") String date);

    @Query(value = "select f.id,\n" +
            "       f.time,\n" +
            "       c.id as cabinet_id\n" +
            "from free_time f\n" +
            "         inner join cabinet c\n" +
            "                    on f.cabinet_id = c.id\n" +
            "                        and c.floor in :floors\n" +
            "                        and c.capacity = :capacity\n" +
            "                        and f.time in :times\n" +
            "where f.time not in (\n" +
            "    select b.time\n" +
            "    from business b\n" +
            "    where b.date = :date\n" +
            "      and b.cabinet_id = f.cabinet_id\n" +
            ")\n" +
            "order by number;", nativeQuery = true)
    List<FreeTime> findFreeTimesByDateAndAndCabinet_CapacityAndCabinet_Floor(
            @Param("date") String date,
            @Param("times") List<String> times,
            @Param("floors") List<Integer> floors,
            @Param("capacity") Integer capacity
    );
}
