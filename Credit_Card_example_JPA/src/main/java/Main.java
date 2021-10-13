import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {


        Pincode pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);

        CreditCard creditCard_1 = new CreditCard();
        creditCard_1.setNumber(12345);
        creditCard_1.setBalance(-5000);
        creditCard_1.setLimit(-10000);
        creditCard_1.setPincode(pincode);

        CreditCard creditCard_2 = new CreditCard();
        creditCard_2.setNumber(123);
        creditCard_2.setBalance(1);
        creditCard_2.setLimit(2000);
        creditCard_2.setPincode(pincode);

        Bank bank = new Bank();
        bank.setName("Pengebank");
        ArrayList<CreditCard> cards = new ArrayList<>();
        cards.add(creditCard_1);
        cards.add(creditCard_2);
        bank.setCards(cards);


        Address address = new Address();
        address.setNumber(28);
        address.setStreet("Inndalsveien");

        Person person = new Person();
        person.setName("Max Mustermann");
        person.setCards(cards);


        ArrayList<Person> occupants = new ArrayList<>();
        occupants.add(person);
        address.setOccupants(occupants);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("test");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(address);
        em.persist(person);
        em.persist(bank);
        em.persist(pincode);
        em.persist(creditCard_1);
        em.persist(creditCard_2);
        em.getTransaction().commit();
        em.close();

    }
}