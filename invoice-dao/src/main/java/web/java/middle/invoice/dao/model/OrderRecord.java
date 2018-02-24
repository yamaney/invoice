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
 * The persistent class for the order_record database table.
 *
 */
@Entity
@Table(name="order_record")
@NamedQuery(name="OrderRecord.findAll", query="SELECT o FROM OrderRecord o")
public class OrderRecord implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The order no. */
	@Id
	@Column(name="order_no")
	private int orderNo;

	/** The client no. */
	@Column(name="client_no")
	private int clientNo;

	/** The create datetime. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_datetime")
	private Date createDatetime;

	/** The del flg. */
	@Column(name="del_flg")
	private String delFlg;

	/** The item count. */
	@Column(name="item_count")
	private int itemCount;

	/** The item name. */
	@Column(name="item_name")
	private String itemName;

	/** The item no. */
	@Column(name="item_no")
	private int itemNo;

	/** The item price. */
	@Column(name="item_price")
	private int itemPrice;

	/** The item type. */
	@Column(name="item_type")
	private String itemType;

	/** The update datetime. */
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="update_datetime")
	private Date updateDatetime;

	/**
	 * Instantiates a new order record.
	 */
	public OrderRecord() {
	}

	/**
	 * Gets the order no.
	 *
	 * @return the order no
	 */
	public int getOrderNo() {
		return this.orderNo;
	}

	/**
	 * Sets the order no.
	 *
	 * @param orderNo the new order no
	 */
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
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
	 * Gets the item count.
	 *
	 * @return the item count
	 */
	public int getItemCount() {
		return this.itemCount;
	}

	/**
	 * Sets the item count.
	 *
	 * @param itemCount the new item count
	 */
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	/**
	 * Gets the item name.
	 *
	 * @return the item name
	 */
	public String getItemName() {
		return this.itemName;
	}

	/**
	 * Sets the item name.
	 *
	 * @param itemName the new item name
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * Gets the item no.
	 *
	 * @return the item no
	 */
	public int getItemNo() {
		return this.itemNo;
	}

	/**
	 * Sets the item no.
	 *
	 * @param itemNo the new item no
	 */
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	/**
	 * Gets the item price.
	 *
	 * @return the item price
	 */
	public int getItemPrice() {
		return this.itemPrice;
	}

	/**
	 * Sets the item price.
	 *
	 * @param itemPrice the new item price
	 */
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * Gets the item type.
	 *
	 * @return the item type
	 */
	public String getItemType() {
		return this.itemType;
	}

	/**
	 * Sets the item type.
	 *
	 * @param itemType the new item type
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
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