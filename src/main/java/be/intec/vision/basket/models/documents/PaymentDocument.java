package be.intec.vision.basket.models.documents;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.Objects;

@Data
@NoArgsConstructor ( force = true, access = AccessLevel.PUBLIC )
@FieldDefaults ( level = AccessLevel.PRIVATE )
@Document ( value = "payments" )
public class PaymentDocument {

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

	@MongoId
	String id;

	Type type=Type.PAYPAL;

	BigDecimal amount=BigDecimal.ZERO;

	Boolean isPaid=Boolean.FALSE;

	Boolean active=Boolean.TRUE;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof PaymentDocument)) return false;
		PaymentDocument that = (PaymentDocument) o;
		return Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public String toString() {

		return this.getType() + " " + this.getAmount();
	}
}
