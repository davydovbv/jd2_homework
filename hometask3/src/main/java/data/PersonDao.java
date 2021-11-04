package data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Person;

import java.io.Serializable;
import java.util.List;

public class PersonDao {

    public Serializable savePerson(Person person) {
        Session session = SessionFactoryHolder.getSession();
        Serializable id = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            id = session.save(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public Person loadById(long id) {
        Session session = SessionFactoryHolder.getSession();
        Person person = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            person = session.load(Person.class, id);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return person;
    }

    public Person getById(long id) {
        Session session = SessionFactoryHolder.getSession();
        Person person = null;
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            person = session.get(Person.class, id);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return person;
    }

    public void deletePersonById(long id) {
        Session session = SessionFactoryHolder.getSession();
        Transaction tr = null;
        try {
            Person person = this.getById(id);
            tr = session.beginTransaction();
            session.delete(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Serializable createAndDeletePerson(Person person) {
        Session session = SessionFactoryHolder.getSession();
        Transaction tr = null;
        Serializable id = null;
        try {
            id = this.savePerson(person);
            tr = session.beginTransaction();
            session.delete(person);
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    public List<Person> readAll() {
        Session session = SessionFactoryHolder.getSession();
        List<Person> personList =
                session.createQuery("SELECT a FROM Person a").list();
        session.close();
        return personList;
    }

    public void removeAllPersons() {
        Session session = SessionFactoryHolder.getSession();
        Transaction tr = null;
        try {
            tr = session.beginTransaction();
            String sql = "TRUNCATE TABLE persons";
            session.createSQLQuery(sql).executeUpdate();
            tr.commit();
        } catch (Exception e) {
            if (tr != null) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}
