package be.intec.vision.basket.models.requests;


import be.intec.vision.basket.models.documents.AddressDocument;
import be.intec.vision.basket.models.documents.ContactDocument;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@AllArgsConstructor
@FieldDefaults ( level = AccessLevel.PRIVATE )
@JsonIgnoreProperties ( ignoreUnknown = true )
public class StoreRequest {


	@MongoId

	String id;
	@NonNull
	String name;

	String about;

	ContactDocument contact;

	AddressDocument address;



}
