package persistance.animal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Animal {
    @Id
    private int id;
    private String clazz;
}
