package web.java.middle.invoice.api.resource;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the invoice.
 *
 * @return the invoice
 */
@Getter

/**
 * Sets the invoice.
 *
 * @param invoice the new invoice
 */
@Setter
public class InvoiceListResource implements Serializable {

	/** The total count. */
	@JsonProperty("total_count")
	private int total_count;

	/** The invoice. */
	@JsonProperty("invoice")
	private List<InvoiceResource> invoice;

}
