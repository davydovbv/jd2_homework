import data.PersonDao;
import data.SessionFactoryHolder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Person;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();
        Person person = new Person();
        person.setId(null);
        person.setAge(17);
        person.setName("Chuck");
        person.setSurname("Norris");
        task2(person, personDao);
        task3(person, personDao);
        task4();
        task5(personDao);
    }

    private static void task2(Person person, PersonDao personDao) {
        long id = (long) personDao.savePerson(person);

        Person getedPerson = personDao.getById(id);
        System.out.println(getedPerson);

        person = new Person();
        person.setId(null);
        person.setAge(15);
        person.setName("Jacky");
        person.setSurname("Chang");
        personDao.savePerson(person);
        personDao.createAndDeletePerson(getedPerson);

        List<Person> persons = personDao.readAll();
        persons.forEach(e -> System.out.println(e.toString()));
    }

    private static void task3(Person person, PersonDao personDao) {
        long id = (long) personDao.savePerson(person);

        Person getedPerson = personDao.getById(id);
        System.out.println("Existing: " + getedPerson);

        Person loadedPerson = personDao.loadById(id);
        System.out.println("Existing: " + loadedPerson);

        getedPerson = personDao.getById(15);
        if (getedPerson != null) {
            System.out.println("Not Existing: " + getedPerson);
        } else {
            System.out.println("\ngetedPerson is null\n");
        }
//        loadedPerson = personDao.loadById(15);
//        System.out.println("Not Existing: " + loadedPerson.getId() + " " + loadedPerson.getName()
//                + " " + loadedPerson.getSurname() + " " + loadedPerson.getAge());
    }

    private static void task4() {
        Session session = SessionFactoryHolder.getSession();
        Person person = session.get(Person.class, 2L);
        System.out.println("1\n" + person);
        person.setAge(35);
        person.setName("Petr");
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.saveOrUpdate(person);
            if (session.isDirty()) {
                session.flush();
            }
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        }

        System.out.println("2\n" + person);
        person.setAge(29);
        person.setName("Ivan");

        try {
            session.saveOrUpdate(person);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        System.out.println("3\n" + person);
        person.setName("Petr");
        person.setAge(35);
        System.out.println("4\n" + person);
        session.refresh(person);
        System.out.println("5\n" + person);
        session.close();
    }

    private static void task5(PersonDao personDao) {
        Person person = new Person();
        person.setAge(23);
        person.setName("Harry");
        person.setSurname("Potter");

        personDao.createAndDeletePerson(person);
        personDao.deletePersonById(2L);
    }
}
