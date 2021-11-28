import org.hibernate.Session;
import org.hibernate.Transaction;
import persistance.animal.Animal;
import persistance.animal.Cat;
import persistance.animal.Dog;
import persistance.drinks.Juice;
import persistance.drinks.Soda;
import persistance.drinks.Water;
import persistance.person.Employee;
import persistance.person.Person;
import persistance.person.Student;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Session session= HibernateUtil.getSession();
        Employee employee = new Employee("Sun",100.00);
        Student student = new Student("Economy", 9.8);
        Person person = new Person(1, "Vasiliy", "Pupkin");

        Water water = new Water(2,1.5);
        Soda soda = new Soda("cola", "CocaCola");
        Juice juice = new Juice(false, "apple");

        Animal animal = new Animal(2, "cats");
        Cat cat = new Cat("Tom", "Jerry");
        Dog dog = new Dog("Lukas", "Natural");

        Transaction transaction = session.beginTransaction();
        session.save(person);
        session.save(employee);
        transaction.commit();

        Transaction tr = session.beginTransaction();
        session.save(water);
        session.save(juice);
        tr.commit();

        Transaction tran = session.beginTransaction();
        session.save(animal);
        session.save(cat);
        tran.commit();
    }
}
