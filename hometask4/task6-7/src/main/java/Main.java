
import component.Address;
import org.hibernate.Session;
import org.hibernate.Transaction;
import persistance.*;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Minsk", "Zelenaya", "2200100");
        Identity identity = new Identity();
        identity.setAddress(address);
        Sequence sequence = new Sequence();
        sequence.setAddress(address);
        Uuid uuid = new Uuid();
        uuid.setAddress(address);

        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            session.save(identity);
            session.save(sequence);
            session.save(uuid);
            tx.commit();

            System.out.println("identity " + identity);
            System.out.println("sequence " + sequence);
            System.out.println("uuid " + uuid);

        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
