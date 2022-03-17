package be.intec.vision.basket.models.responses;


import be.intec.vision.basket.models.documents.ContactDocument;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.MongoId;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.UUID;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@AllArgsConstructor
@FieldDefaults ( level = AccessLevel.PRIVATE )
@JsonIgnoreProperties ( ignoreUnknown = true )
public class ContactResponse {



	public enum Type {
		BILLING,
		SHIPPING,
		ALL
	}



	String id;

	Type type;

	@NonNull
	@Email
	String email;
	@NonNull
	@Min(9)
	@Max(15)
	String phone;
	String activation;

	Boolean active;

}
