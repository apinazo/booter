package es.apinazo.booter.business.people;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1") // Cats will have a '1' in the 'kind' column.
public class Cat extends Pet {

    public Cat(){}

    public Cat(String name, int age, Gender gender) {
        super(name, age, gender);
    }

}
