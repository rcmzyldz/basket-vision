package be.intec.vision.basket.models.documents;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(value = "contacts")
public class ContactDocument {

    public enum Type {
        BILLING,
        SHIPPING,
        ALL
    }

    @MongoId
    String id;

    Type type = Type.ALL;
    @NonNull
    @Email
    String email;
    @NonNull
    @Min(9)
    @Max(15)
    String phone;
    String activation = UUID.randomUUID().toString();

    Boolean active = Boolean.TRUE;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactDocument)) return false;
        ContactDocument that = (ContactDocument) o;
        return Objects.equals(getId(), that.getId()) && getEmail().equals(that.getEmail()) && getPhone().equals(that.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail(), getPhone());
    }

    @Override
    public String toString() {
        if (this.getEmail() != null) {
            return this.getEmail();
        } else if (this.getPhone() != null) {
            return this.getPhone();
        } else {
            return "No such contact! ";
        }

    }
}
