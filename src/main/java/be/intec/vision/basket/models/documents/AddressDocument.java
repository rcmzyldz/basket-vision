package be.intec.vision.basket.models.documents;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

@Data
@NoArgsConstructor(force = true, access = AccessLevel.PUBLIC)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(value = "addresses")
public class AddressDocument {

    public enum Type {
        BILLING,
        SHIPPING,
        ALL
    }

    @MongoId
    String id;

    Type type = Type.ALL;

    String doorNo;
    @NonNull
    String buildingNo;
    @NonNull
    String street;

    String municipality;
    @NonNull
    String postCode;
    @NonNull
    String city;

    String region;
    @NonNull
    String country;


    String latitude;

    String longitude;
    String activation = UUID.randomUUID().toString();

    Boolean active = Boolean.TRUE;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressDocument)) return false;
        AddressDocument that = (AddressDocument) o;
        return Objects.equals(getDoorNo(), that.getDoorNo()) && Objects.equals(getBuildingNo(), that.getBuildingNo()) && Objects.equals(getStreet(), that.getStreet()) && Objects.equals(getMunicipality(), that.getMunicipality()) && getPostCode().equals(that.getPostCode()) && getCity().equals(that.getCity()) && Objects.equals(getRegion(), that.getRegion()) && getCountry().equals(that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDoorNo(), getBuildingNo(), getStreet(), getMunicipality(), getPostCode(), getCity(), getRegion(), getCountry());
    }

    @Override
    public String toString() {
        return Objects.requireNonNull(this.getStreet()) + " " +
                Objects.requireNonNull(this.getBuildingNo()) + " " +
                Objects.requireNonNull(this.getDoorNo()) + " " +
                Objects.requireNonNull(this.getPostCode()) + " " +
                Objects.requireNonNull(this.getMunicipality()) + " " +
                Objects.requireNonNull(this.getCity()) + " " +
                Objects.requireNonNull(this.getRegion()) + " " +
                Objects.requireNonNull(this.getCountry()) + ".";
    }
}