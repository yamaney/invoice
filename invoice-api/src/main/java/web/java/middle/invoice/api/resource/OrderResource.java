package web.java.middle.invoice.api.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the count.
 *
 * @return the count
 */
@Getter

/**
 * Sets the count.
 *
 * @param count the new count
 */
@Setter
public class OrderResource implements Serializable {

	/** The order no. */
	private int order_no;

	/** The no. */
	private int no;

	/** The name. */
	private String name;

	/** The type. */
	private String type;

	/** The price. */
	private int price;

	/** The count. */
	private int count;
}
