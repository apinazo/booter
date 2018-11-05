package es.apinazo.booter.business.people;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2") // Cats will have a '2' in the 'kind' column.
public class Dog extends Pet {

    public Dog(){}

    public Dog(String name, int age, Gender gender) {
        super(name, age, gender);
    }

}
