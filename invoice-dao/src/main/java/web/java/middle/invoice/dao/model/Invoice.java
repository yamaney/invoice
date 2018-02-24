package web.java.middle.invoice.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the invoice database table.
 *
 */
@Entity
@Table(name = "invoice")
@NamedQuery(name="Invoice.findAll", query="SELECT i FROM Invoice i")
public class Invoice implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The invoice no. */
	@Id
	@GeneratedValue
	@Column(name="invoice_no")
	private int invoiceNo;

	/** The client no. */
	@Column(name="client_no")
	private int clientNo;

	/** The create datetime. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_datetime")
	private Date createDatetime;

	/** The create user. */
	@Column(name="create_user")
	private String createUser;

	/** The del flg. */
	@Column(name="del_flg")
	private String delFlg;

	/** The invoice amt. */
	@Column(name="invoice_amt")
	private int invoiceAmt;

	/** The invoice create date. */
	@Temporal(TemporalType.DATE)
	@Column(name="invoice_create_date")
	private Date invoiceCreateDate;

	/** The invoice end date. */
	@Temporal(TemporalType.DATE)
	@Column(name="invoice_end_date")
	private Date invoiceEndDate;

	/** The invoice note. */
	@Column(name="invoice_note")
	private String invoiceNote;

	/** The invoice start date. */
	@Temporal(TemporalType.DATE)
	@Column(name="invoice_start_date")
	private Date invoiceStartDate;

	/** The invoice status. */
	@Column(name="invoice_status")
	private String invoiceStatus;

	/** The invoice title. */
	@Column(name="invoice_title")
	private String invoiceTitle;

	/** The tax amt. */
	@Column(name="tax_amt")
	private int taxAmt;

	/** The update datetime. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_datetime")
	private Date updateDatetime;

	/** The update user. */
	@Column(name="update_user")
	private String updateUser;

	/**
	 * Instantiates a new invoice.
	 */
	public Invoice() {
	}

	/**
	 * Gets the invoice no.
	 *
	 * @return the invoice no
	 */
	public int getInvoiceNo() {
		return this.invoiceNo;
	}

	/**
	 * Sets the invoice no.
	 *
	 * @param invoiceNo the new invoice no
	 */
	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	/**
	 * Gets the client no.
	 *
	 * @return the client no
	 */
	public int getClientNo() {
		return this.clientNo;
	}

	/**
	 * Sets the client no.
	 *
	 * @param clientNo the new client no
	 */
	public void setClientNo(int clientNo) {
		this.clientNo = clientNo;
	}

	/**
	 * Gets the creates the datetime.
	 *
	 * @return the creates the datetime
	 */
	public Date getCreateDatetime() {
		return this.createDatetime;
	}

	/**
	 * Sets the creates the datetime.
	 *
	 * @param createDatetime the new creates the datetime
	 */
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	/**
	 * Gets the creates the user.
	 *
	 * @return the creates the user
	 */
	public String getCreateUser() {
		return this.createUser;
	}

	/**
	 * Sets the creates the user.
	 *
	 * @param createUser the new creates the user
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * Gets the del flg.
	 *
	 * @return the del flg
	 */
	public String getDelFlg() {
		return this.delFlg;
	}

	/**
	 * Sets the del flg.
	 *
	 * @param delFlg the new del flg
	 */
	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	/**
	 * Gets the invoice amt.
	 *
	 * @return the invoice amt
	 */
	public int getInvoiceAmt() {
		return this.invoiceAmt;
	}

	/**
	 * Sets the invoice amt.
	 *
	 * @param invoiceAmt the new invoice amt
	 */
	public void setInvoiceAmt(int invoiceAmt) {
		this.invoiceAmt = invoiceAmt;
	}

	/**
	 * Gets the invoice create date.
	 *
	 * @return the invoice create date
	 */
	public Date getInvoiceCreateDate() {
		return this.invoiceCreateDate;
	}

	/**
	 * Sets the invoice create date.
	 *
	 * @param invoiceCreateDate the new invoice create date
	 */
	public void setInvoiceCreateDate(Date invoiceCreateDate) {
		this.invoiceCreateDate = invoiceCreateDate;
	}

	/**
	 * Gets the invoice end date.
	 *
	 * @return the invoice end date
	 */
	public Date getInvoiceEndDate() {
		return this.invoiceEndDate;
	}

	/**
	 * Sets the invoice end date.
	 *
	 * @param invoiceEndDate the new invoice end date
	 */
	public void setInvoiceEndDate(Date invoiceEndDate) {
		this.invoiceEndDate = invoiceEndDate;
	}

	/**
	 * Gets the invoice note.
	 *
	 * @return the invoice note
	 */
	public String getInvoiceNote() {
		return this.invoiceNote;
	}

	/**
	 * Sets the invoice note.
	 *
	 * @param invoiceNote the new invoice note
	 */
	public void setInvoiceNote(String invoiceNote) {
		this.invoiceNote = invoiceNote;
	}

	/**
	 * Gets the invoice start date.
	 *
	 * @return the invoice start date
	 */
	public Date getInvoiceStartDate() {
		return this.invoiceStartDate;
	}

	/**
	 * Sets the invoice start date.
	 *
	 * @param invoiceStartDate the new invoice start date
	 */
	public void setInvoiceStartDate(Date invoiceStartDate) {
		this.invoiceStartDate = invoiceStartDate;
	}

	/**
	 * Gets the invoice status.
	 *
	 * @return the invoice status
	 */
	public String getInvoiceStatus() {
		return this.invoiceStatus;
	}

	/**
	 * Sets the invoice status.
	 *
	 * @param invoiceStatus the new invoice status
	 */
	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	/**
	 * Gets the invoice title.
	 *
	 * @return the invoice title
	 */
	public String getInvoiceTitle() {
		return this.invoiceTitle;
	}

	/**
	 * Sets the invoice title.
	 *
	 * @param invoiceTitle the new invoice title
	 */
	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	/**
	 * Gets the tax amt.
	 *
	 * @return the tax amt
	 */
	public int getTaxAmt() {
		return this.taxAmt;
	}

	/**
	 * Sets the tax amt.
	 *
	 * @param taxAmt the new tax amt
	 */
	public void setTaxAmt(int taxAmt) {
		this.taxAmt = taxAmt;
	}

	/**
	 * Gets the update datetime.
	 *
	 * @return the update datetime
	 */
	public Date getUpdateDatetime() {
		return this.updateDatetime;
	}

	/**
	 * Sets the update datetime.
	 *
	 * @param updateDatetime the new update datetime
	 */
	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	/**
	 * Gets the update user.
	 *
	 * @return the update user
	 */
	public String getUpdateUser() {
		return this.updateUser;
	}

	/**
	 * Sets the update user.
	 *
	 * @param updateUser the new update user
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}