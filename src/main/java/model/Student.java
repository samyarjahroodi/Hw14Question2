package model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Version;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person {
    @NotNull
    private long studentsCode;
    @NotNull
    private String field;
    @NotNull
    private int entranceYear;
}
