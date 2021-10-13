import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String street;
    private Integer number;

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = Id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    

    @ManyToMany(mappedBy = "address")
    private ArrayList<Person> occupants = new ArrayList<Person>();
    public ArrayList<Person> getOccupants() {
        return this.occupants;
    }

    public void setOccupants(ArrayList<Person> occupants) {
        this.occupants = occupants;
    }
}