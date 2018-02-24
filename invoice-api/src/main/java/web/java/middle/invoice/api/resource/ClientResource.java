package web.java.middle.invoice.api.resource;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the fax.
 *
 * @return the fax
 */
@Getter

/**
 * Sets the fax.
 *
 * @param fax the new fax
 */
@Setter
public class ClientResource implements Serializable {

	/** The no. */
	private int no;

	/** The charge last name. */
	private String charge_last_name;

	/** The charge first name. */
	private String charge_first_name;

	/** The name. */
	private String name;

	/** The address. */
	private String address;

	/** The tel. */
	private String tel;

	/** The fax. */
	private String fax;
}
