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
    @Version
    private long version;
    @NotNull
    private int studentsCode;
    @NotNull
    private String field;
    @NotNull
    private int entranceYear;
}
