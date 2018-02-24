package web.java.middle.invoice.api.resource;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the item.
 *
 * @return the item
 */
@Getter

/**
 * Sets the item.
 *
 * @param item the new item
 */
@Setter
public class InvoiceResource implements Serializable {

	/** The no. */
	private int no;

	/** The status. */
	private String status;

	/** The create date. */
	private String create_date;

	/** The title. */
	private String title;

	/** The amt. */
	private int amt;

	/** The tax. */
	private int tax;

	/** The start date. */
	private String start_date;

	/** The end date. */
	private String end_date;

	/** The note. */
	private String note;

	/** The client. */
	private ClientResource client;

	/** The item count. */
	private int item_count;

	/** The item. */
	private List<OrderResource> item;
}
