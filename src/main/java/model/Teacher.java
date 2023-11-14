package model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends Person {
    @NotNull
    private int teachersCode;

    @Enumerated(EnumType.STRING)
    @NotNull
    private model.teachersDegree teachersDegree;

    @Enumerated(EnumType.STRING)
    @NotNull
    private model.teachersRate teachersRate;

    @NotNull
    private int salary;
}

