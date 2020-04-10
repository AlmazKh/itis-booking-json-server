package ru.itis.almaz.jsonserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    @Enumerated(value = EnumType.STRING)
    private Time time;
    @Enumerated(value = EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn
    private Cabinet cabinet;
    @ManyToOne
    @JoinColumn
    private Usr usr;
}
