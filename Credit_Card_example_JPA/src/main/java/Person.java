import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    private ArrayList<CreditCard> cards;

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    public ArrayList<CreditCard> getCards() {
        return this.cards;
    }

    public void setCards(ArrayList<CreditCard> cards) {
        this.cards = cards;
    }


    @ManyToMany
    private List<Address> address = new ArrayList<>();
}