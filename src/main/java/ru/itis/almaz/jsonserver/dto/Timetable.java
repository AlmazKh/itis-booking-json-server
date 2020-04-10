package ru.itis.almaz.jsonserver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.almaz.jsonserver.model.Business;
import ru.itis.almaz.jsonserver.model.Cabinet;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Timetable {
    private List<Business> businesses;
}
