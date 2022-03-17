package be.intec.vision.basket.models.documents;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@FieldDefaults ( level = AccessLevel.PRIVATE )
@Document ( value = "tokens", collection = "tokens" )
public class TokenDocument {

	@MongoId
	String id;

	@NonNull
	String hashValue;

	@FutureOrPresent
	LocalDateTime createdAt;

	@FutureOrPresent
	LocalDateTime updatedAt;

	Boolean active = Boolean.TRUE;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof TokenDocument)) return false;
		TokenDocument that = (TokenDocument) o;
		return Objects.equals(getId(), that.getId()) && getHashValue().equals(that.getHashValue());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getHashValue());
	}

	@Override
	public String toString() {
		return this.getHashValue();
	}
}
