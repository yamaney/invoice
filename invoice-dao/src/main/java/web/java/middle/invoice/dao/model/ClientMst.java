package web.java.middle.invoice.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the client_mst database table.
 *
 */
@Entity
@Table(name="client_mst")
@NamedQuery(name="ClientMst.findAll", query="SELECT c FROM ClientMst c")
public class ClientMst implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The client no. */
	@Id
	@Column(name="client_no")
	private int clientNo;

	/** The client address. */
	@Column(name="client_address")
	private String clientAddress;

	/** The client charge first name. */
	@Column(name="client_charge_first_name")
	private String clientChargeFirstName;

	/** The client charge last name. */
	@Column(name="client_charge_last_name")
	private String clientChargeLastName;

	/** The client fax. */
	@Column(name="client_fax")
	private String clientFax;

	/** The client name. */
	@Column(name="client_name")
	private String clientName;

	/** The client tel. */
	@Column(name="client_tel")
	private String clientTel;

	/** The create datetime. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_datetime")
	private Date createDatetime;

	/** The del flg. */
	@Column(name="del_flg")
	private String delFlg;

	/** The update datetime. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_datetime")
	private Date updateDatetime;

	/**
	 * Instantiates a new client mst.
	 */
	public ClientMst() {
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
	 * Gets the client address.
	 *
	 * @return the client address
	 */
	public String getClientAddress() {
		return this.clientAddress;
	}

	/**
	 * Sets the client address.
	 *
	 * @param clientAddress the new client address
	 */
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	/**
	 * Gets the client charge first name.
	 *
	 * @return the client charge first name
	 */
	public String getClientChargeFirstName() {
		return this.clientChargeFirstName;
	}

	/**
	 * Sets the client charge first name.
	 *
	 * @param clientChargeFirstName the new client charge first name
	 */
	public void setClientChargeFirstName(String clientChargeFirstName) {
		this.clientChargeFirstName = clientChargeFirstName;
	}

	/**
	 * Gets the client charge last name.
	 *
	 * @return the client charge last name
	 */
	public String getClientChargeLastName() {
		return this.clientChargeLastName;
	}

	/**
	 * Sets the client charge last name.
	 *
	 * @param clientChargeLastName the new client charge last name
	 */
	public void setClientChargeLastName(String clientChargeLastName) {
		this.clientChargeLastName = clientChargeLastName;
	}

	/**
	 * Gets the client fax.
	 *
	 * @return the client fax
	 */
	public String getClientFax() {
		return this.clientFax;
	}

	/**
	 * Sets the client fax.
	 *
	 * @param clientFax the new client fax
	 */
	public void setClientFax(String clientFax) {
		this.clientFax = clientFax;
	}

	/**
	 * Gets the client name.
	 *
	 * @return the client name
	 */
	public String getClientName() {
		return this.clientName;
	}

	/**
	 * Sets the client name.
	 *
	 * @param clientName the new client name
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * Gets the client tel.
	 *
	 * @return the client tel
	 */
	public String getClientTel() {
		return this.clientTel;
	}

	/**
	 * Sets the client tel.
	 *
	 * @param clientTel the new client tel
	 */
	public void setClientTel(String clientTel) {
		this.clientTel = clientTel;
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

}