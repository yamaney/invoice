package web.java.middle.invoice.api.resource;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
public class RegistResponseResource implements Serializable {

	/** The total count. */
	private int total_count;

	/** The invoice. */
	private List<Map<String, Integer>> invoice;

}
