package be.intec.vision.basket.models.requests;


import be.intec.vision.basket.models.documents.AddressDocument;
import be.intec.vision.basket.models.documents.ContactDocument;
import be.intec.vision.basket.models.documents.TokenDocument;
import be.intec.vision.basket.models.responses.CustomerResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@AllArgsConstructor
@FieldDefaults ( level = AccessLevel.PRIVATE )
@JsonIgnoreProperties ( ignoreUnknown = true )
public class CustomerRequest {


	public enum Type {
		INDIVIDUAL, COMPANY}



	public enum Gender {
		MALE,
		FEMALE,
		OTHER

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




}
