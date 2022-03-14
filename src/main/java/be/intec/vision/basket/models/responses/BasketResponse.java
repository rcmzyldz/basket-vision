package be.intec.vision.basket.models.responses;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@AllArgsConstructor
@FieldDefaults ( level = AccessLevel.PRIVATE )
@JsonIgnoreProperties ( ignoreUnknown = true )
public class BasketResponse {

	public enum Type {
		SHOPPING_CART,
		WISH_LIST
	}

	String basketId;

	Type type;

	String session;

	CustomerResponse customer;

	StoreResponse store;

	BigDecimal totalPrice;
	BigDecimal totalTax;
	BigDecimal totalDiscount;

	Set< ProductResponse > products = new LinkedHashSet<>();
	Set< PaymentResponse > payments = new LinkedHashSet<>();

	LocalDateTime createdAt; //expiration time 30m

	LocalDateTime updatedAt;

	Boolean active = Boolean.TRUE;

}
