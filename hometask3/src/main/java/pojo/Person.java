package pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
@ToString
@Entity
@Table(name = "persons")
@Transactional
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer age;
    @Column
    private String name;
    @Column
    private String surname;
}
