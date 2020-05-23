package ru.itis.almaz.restful_server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.almaz.restful_server.model.FreeTime;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimetableFreeTimeByDate {
    private List<FreeTime> freeTimes;
}
