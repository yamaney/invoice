package web.java.middle.invoice.api.resource;

import java.io.Serializable;

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
 * @param invoice the invoice
 */
@Setter
public class InvoiceApiErrorResource implements Serializable {

	@JsonProperty("message")
	private String message;



}
