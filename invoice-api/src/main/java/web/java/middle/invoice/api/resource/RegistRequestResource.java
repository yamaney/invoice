package web.java.middle.invoice.api.resource;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the item type.
 *
 * @return the item type
 */
@Getter

/**
 * Sets the item type.
 *
 * @param itemType the new item type
 */
@Setter
public class RegistRequestResource implements Serializable {


	/** The client no. */
	@JsonProperty("client_no")
	private int clientNo;

	/** The title. */
	@JsonProperty("title")
	@Size(max = 300)
	private String title;

	/** The start date. */
	@JsonProperty("start_date")
	@NotEmpty(message ="Start Date is requered")
	private String startDate;

	/** The end date. */
	@JsonProperty("end_date")
	@NotEmpty(message = "End Date is requered")
	private String endDate;

	/** The note. */
	@JsonProperty("note")
	@Size(max = 3000)
	private String note;

	/** The item type. */
	@JsonProperty("item_type")
	private String itemType;
}
