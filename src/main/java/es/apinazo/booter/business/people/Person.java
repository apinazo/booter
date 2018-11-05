package es.apinazo.booter.business.people;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Person {

    public Person(String firstName, String lastName, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // A linear sequence for each entity.
    private Integer id; // Long should be used if a big deal of IDs are to be expected.

    @Basic(optional = false) // Not nullable, but @Basic checks it before accessing the DB.
    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String personalId;

    @Enumerated
    private Gender gender;

    @JsonManagedReference // To avoid exceptions if no transaction is present.
    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    @OrderBy // Ordering by primary key is assumed.
    // A Set is more efficient, avoids repetitions and the n-bag in queries problem.
    private Set<Pet> pets = new HashSet<>();

    /**
     * Adds a {@link Pet} to a {@link Person}.
     *
     * Since the {@link OneToMany} is bidirectional, changes must be made
     * in both sides. Having this utility method helps to avoid bugs
     * and to sync both sides of the relationship.
     *
     * @param pet The {@link Pet}.
     */
    public void addPet(Pet pet) {
        this.pets.add(pet);
        pet.setOwner(this);
    }

    /**
     * Removes a {@link Pet} from a {@link Person}.
     *
     * @param pet The {@link Pet}.
     */
    public void removePet(Pet pet) {
        this.pets.remove(pet);
        pet.setOwner(null);
    }

}
