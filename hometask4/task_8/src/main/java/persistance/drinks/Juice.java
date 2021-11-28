package persistance.drinks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "JUICE")
@PrimaryKeyJoinColumn(name = "WATER_ID")
public class Juice extends Water {
    private boolean sugar;
    private String taste;
}
