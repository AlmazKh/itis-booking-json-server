package ru.itis.almaz.jsonserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.springframework.cglib.core.KeyFactory;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cabinet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer capacity;
    @ElementCollection(targetClass = Status.class)
    @MapKeyClass(Time.class)
    @MapKeyEnumerated(EnumType.STRING)
    @Enumerated(value = EnumType.STRING)
    private Map<Time, Status> business;
}
