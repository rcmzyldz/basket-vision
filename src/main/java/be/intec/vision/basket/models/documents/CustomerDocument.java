package be.intec.vision.basket.models.documents;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(value = "customers")
public class CustomerDocument {


    public enum Type {
        INDIVIDUAL, COMPANY
    }


    @MongoId
    String id;

    Type type;

    String company;

    String title;

    @NonNull
    String firstName;

    @NonNull
    String lastName;

    LocalDate dateOfBirth;

    Set<TokenDocument> tokens;

    String activation;

    Set<AddressDocument> addresses = new HashSet<>();

    Set<ContactDocument> contacts = new HashSet<>();

    Boolean active = Boolean.TRUE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerDocument)) return false;
        CustomerDocument that = (CustomerDocument) o;
        return Objects.equals(getId(), that.getId()) && getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getDateOfBirth().equals(that.getDateOfBirth()) && getContacts().equals(that.getContacts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getDateOfBirth(), getContacts());
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName();
    }
}
