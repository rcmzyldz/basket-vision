package be.intec.vision.basket.models.requests;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@FieldDefaults ( level = AccessLevel.PRIVATE )
@JsonIgnoreProperties ( ignoreUnknown = true )
public class ContactRequest {

	String contactId;

	String email;

	String phone;

}
