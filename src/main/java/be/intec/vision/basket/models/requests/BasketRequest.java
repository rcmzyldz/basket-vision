package be.intec.vision.basket.models.requests;


import be.intec.vision.basket.models.documents.CustomerDocument;
import be.intec.vision.basket.models.documents.StoreDocument;
import be.intec.vision.basket.models.responses.BasketResponse;
import be.intec.vision.basket.models.responses.PaymentResponse;
import be.intec.vision.basket.models.responses.ProductResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@AllArgsConstructor
@FieldDefaults ( level = AccessLevel.PRIVATE )
@JsonIgnoreProperties ( ignoreUnknown = true )
public class BasketRequest {


	public enum Type {
		SHOPPING_CART,
		WISH_LIST
	}

	@MongoId
	String id;

	Type type;

	String session;

	CustomerDocument customer;

	StoreDocument store;

	BigDecimal totalPrice;
	BigDecimal totalTax;
	BigDecimal totalDiscount;

	Set<ProductResponse> products = new LinkedHashSet<>();
	Set<PaymentResponse> payments = new LinkedHashSet<>();

	LocalDateTime createdAt; //expiration time 30m

	LocalDateTime updatedAt;

	Boolean active ;

}
