package be.intec.vision.basket.models.documents;


import com.mongodb.lang.NonNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@FieldDefaults ( level = AccessLevel.PRIVATE )
@Document ( value = "stores", collection = "stores")
public class StoreDocument {


	@MongoId
	String id;
	@NonNull
	String name;

	String about;

	ContactDocument contact;

	AddressDocument address;

	Boolean active=Boolean.TRUE;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof StoreDocument)) return false;
		StoreDocument that = (StoreDocument) o;
		return Objects.equals(getId(), that.getId()) && getName().equals(that.getName()) && getAddress().equals(that.getAddress());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName(), getAddress());
	}

	@Override
	public String toString() {
		return this.getName();
	}
}
