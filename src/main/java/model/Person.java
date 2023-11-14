package model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String DOB;

    public Person(String firstName, String lastName, String DOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
    }
}
