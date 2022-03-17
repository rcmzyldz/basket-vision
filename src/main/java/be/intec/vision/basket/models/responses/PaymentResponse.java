package be.intec.vision.basket.models.responses;


import be.intec.vision.basket.models.documents.PaymentDocument;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@AllArgsConstructor
@FieldDefaults ( level = AccessLevel.PRIVATE )
@JsonIgnoreProperties ( ignoreUnknown = true )
public class PaymentResponse {

	public enum Type {
		CASH,
		CREDIT_CARD,
		DEBIT_CARD,
		PREPAID_CARD,
		PAYPAL,
		PAYPAL_GUEST_CHECKOUT,
		AMAZON_PAY,
		BANK_TRANSFER,
		APPLE_WALLET,
		GOOGLE_PAY,
		KLARNA,
		GIFTCARD,
		BITCOIN,
		ETHEREUM,
		COD,
		AMERICAN_EXPRESS,
		UNION_PAY,
		QIWI,
		SKRILL

	}



	String id;

	Type type;

	BigDecimal amount;

	Boolean isPaid;

	Boolean active;

}
