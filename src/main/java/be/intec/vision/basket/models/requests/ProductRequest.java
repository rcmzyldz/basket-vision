package be.intec.vision.basket.models.requests;


import be.intec.vision.basket.models.documents.MediaDocument;
import be.intec.vision.basket.models.responses.ProductResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@AllArgsConstructor
@FieldDefaults ( level = AccessLevel.PRIVATE )
@JsonIgnoreProperties ( ignoreUnknown = true )
public class ProductRequest {


	public enum Type {
		SINGLE,
		COMBINED,
		FREE
	}

	@MongoId
	String id;

	ProductResponse.Type type;

	String slug;

	String ean;

	String title;

	String description;

	Float quantity;

	String currency ;
	@NonNull
	BigDecimal price;

	BigDecimal tax;

	BigDecimal discount;

	BigDecimal deliveryCost;


	Set<MediaDocument> medias = new HashSet<>();



}
