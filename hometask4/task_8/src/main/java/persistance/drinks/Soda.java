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
@Table(name = "SODA")
@PrimaryKeyJoinColumn(name = "WATER_ID")
public class Soda extends Water {
    public String type;
    public String brand;
}
