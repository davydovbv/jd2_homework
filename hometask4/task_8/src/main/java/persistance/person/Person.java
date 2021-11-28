package persistance.person;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PERSON")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PERSON_TYPE", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue("P")
public class Person {
    @Id
    private int id;
    private String name;
    private String surname;
}
