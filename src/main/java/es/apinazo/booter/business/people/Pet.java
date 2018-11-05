package es.apinazo.booter.business.people;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

// Tell Jackson to add a property named "type" to the JSON for Pet subclasses.
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    // A Cat will have type="cat".
    @JsonSubTypes.Type(value = Cat.class, name = "cat"),
    // And a Dog, type="dog".
    @JsonSubTypes.Type(value = Dog.class, name = "dog")
})
@Data
@NoArgsConstructor
@ToString(exclude = "owner") // Exclude person to avoid loops.
@EqualsAndHashCode(exclude = "owner")
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// Integer discriminator is less clear but much more efficient than a String one.
@DiscriminatorColumn(name = "kind", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int age;

    @Enumerated
    private Gender gender;

    @JsonIgnore // To break infinite recursion with Person.
    @ManyToOne(fetch = FetchType.LAZY)
    private Person owner;


    public Pet(String name, int age, Gender gender) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

}
