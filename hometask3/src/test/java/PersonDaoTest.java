import data.PersonDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.Person;

import java.io.Serializable;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class PersonDaoTest {
    PersonDao personDao;

    @Before
    public void setUp() throws Exception {
        personDao = new PersonDao();
    }

    @After
    public void tearDown() throws Exception {
        personDao = null;
    }



    @Test
    public void savePerson() {
        //Given
        Person person = new Person();
        person.setId(null);
        person.setAge(15);
        person.setName("Ivan");
        person.setSurname("Petrov");

        //When
        Serializable id = personDao.savePerson(person);

        //Then
        assertNotNull(id);
        personDao.removeAllPersons();
    }

    @Test
    public void  getById() {
        //Given
        Person person = new Person();
        person.setId(null);
        person.setAge(17);
        person.setName("Chuck");
        person.setSurname("Norris");
        long id = (long) personDao.savePerson(person);
        person.setId(id);

        //When
        Person foundPerson = personDao.getById(id);

        //Then
        assertEquals(person.getId(), foundPerson.getId());
        assertEquals(person.getAge(), foundPerson.getAge());
        assertEquals(person.getName(), foundPerson.getName());
        assertEquals(person.getSurname(), foundPerson.getSurname());
        personDao.removeAllPersons();
    }

    @Test
    public void  loadById() {
        //Given
        Person person = new Person();
        person.setId(null);
        person.setAge(17);
        person.setName("Chuck");
        person.setSurname("Norris");
        long id = (long) personDao.savePerson(person);
        person.setId(id);

        //When
        Person foundPerson = personDao.loadById(id);

        //Then
        assertEquals(person.getId(), foundPerson.getId());
        assertEquals(person.getAge(), foundPerson.getAge());
        assertEquals(person.getName(), foundPerson.getName());
        assertEquals(person.getSurname(), foundPerson.getSurname());
        personDao.removeAllPersons();
    }

    @Test
    public void deletePersonById() {
        //Given
        Person person = new Person();
        person.setId(null);
        person.setAge(17);
        person.setName("Chuck");
        person.setSurname("Norris");
        long id = (long) personDao.savePerson(person);
        person.setId(id);

        //When
        personDao.deletePersonById(id);

        //Then
        assertNull(personDao.getById(id));
        personDao.removeAllPersons();
    }

    @Test
    public void createAndDeletePerson() {
        //Given
        Person person = new Person();
        person.setId(null);
        person.setAge(17);
        person.setName("Chuck");
        person.setSurname("Norris");

        //When
        long id = (long) personDao.createAndDeletePerson(person);

        //Then
        assertNull(personDao.getById(id));
        personDao.removeAllPersons();
    }

    @Test
    public void readAll() {
        //Given
        Person person1 = new Person();
        person1.setId(null);
        person1.setAge(17);
        person1.setName("Chuck");
        person1.setSurname("Norris");

        Person person2 =  new Person();
        person2.setAge(25);
        person2.setName("Harry");
        person2.setSurname("Potter");

        personDao.savePerson(person1);
        personDao.savePerson(person2);

        //When
        List<Person> list = personDao.readAll();

        //Then
        assertEquals(2, list.size());
        personDao.removeAllPersons();
    }
}
