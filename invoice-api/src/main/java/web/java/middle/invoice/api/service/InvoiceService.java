package web.java.middle.invoice.api.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.java.middle.invoice.api.resource.ClientResource;
import web.java.middle.invoice.api.resource.InvoiceListResource;
import web.java.middle.invoice.api.resource.InvoiceResource;
import web.java.middle.invoice.api.resource.OrderResource;
import web.java.middle.invoice.api.resource.RegistRequestResource;
import web.java.middle.invoice.api.resource.RegistResponseResource;
import web.java.middle.invoice.dao.model.ClientMst;
import web.java.middle.invoice.dao.model.Invoice;
import web.java.middle.invoice.dao.model.OrderRecord;
import web.java.middle.invoice.dao.repository.ClientMstRepository;
import web.java.middle.invoice.dao.repository.InvoiceRepository;
import web.java.middle.invoice.dao.repository.OrderRecordRepository;

/**
 * The Class InvoiceService.
 */
@Service
public class InvoiceService {

	/** The invoice repository. */
	@Autowired
	InvoiceRepository invoiceRepository;

	/** The client mst repository. */
	@Autowired
	ClientMstRepository clientMstRepository;

	/** The order record repository. */
	@Autowired
	OrderRecordRepository orderRecordRepository;

	/**
	 * Gets the invoice all.
	 *
	 * @return the invoice all
	 * @throws Exception the exception
	 */
	@Transactional
	public InvoiceListResource getInvoiceAll() throws Exception {
		// 返却用リソース
		InvoiceListResource invoiceListResource = new InvoiceListResource();

		// 請求書を全件取得する
		List<Invoice> invoiceList = invoiceRepository.findAll();
		// 請求書詳細取得
		List<InvoiceResource> invoiceResourceList = getInvoice(invoiceList);

		// 請求書リスト
		invoiceListResource.setInvoice(invoiceResourceList);
		// 取得件数
		invoiceListResource.setTotal_count(invoiceResourceList.size());

		return invoiceListResource;
	}

	/**
	 * Gets the invoice info.
	 *
	 * @param invoiceNo the invoice no
	 * @return the invoice info
	 * @throws Exception the exception
	 */
	@Transactional
	public InvoiceListResource getInvoiceInfo(int invoiceNo) throws Exception {
		// 返却用リソース
		InvoiceListResource invoiceListResource = new InvoiceListResource();

		// 請求書管理IDから請求書を取得する
		Invoice invoice = invoiceRepository.findOne(invoiceNo);
		if (invoice == null) {
			return invoiceListResource;
		}
		// 請求書詳細取得用リスト
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		// 請求書をリストに設定
		invoiceList.add(invoice);
		// 請求書詳細取得
		List<InvoiceResource> invoiceResourceList = getInvoice(invoiceList);

		// 請求書リスト
		invoiceListResource.setInvoice(invoiceResourceList);
		// 取得件数
		invoiceListResource.setTotal_count(invoiceResourceList.size());

		return invoiceListResource;
	}

	/**
	 * Gets the invoice.
	 *
	 * @param invoiceList the invoice list
	 * @return the invoice
	 * @throws Exception the exception
	 */
	@Transactional
	private List<InvoiceResource> getInvoice(List<Invoice> invoiceList) throws Exception {
		// 請求書詳細保持用リスト
		List<InvoiceResource> invoiceResourceList = new ArrayList<InvoiceResource>();

		// 請求書格納用リソース
		InvoiceResource invoiceResource = null;
		// 顧客情報格納用リソース
		ClientResource clientResource = null;
		// 注文実績格納用リソース
		OrderResource orderResource = null;
		// 顧客情報取得用
		ClientMst client = null;
		// 顧客情報取得用
		List<OrderRecord> orderList = null;
		// 注文実績取得用
		List<OrderResource> orders = null;

		// 顧客情報保持用
		Map<Integer, ClientResource> clientList = new HashMap<Integer, ClientResource>();

		// 日付フォーマット
		SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat formatDateTimeForInvoice = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

		for (Invoice invoice : invoiceList) {
			invoiceResource = new InvoiceResource();

			// 請求書管理番号
			invoiceResource.setNo(invoice.getInvoiceNo());
			// 請求状態
			invoiceResource.setStatus(invoice.getInvoiceStatus());
			// 請求書作成日
			invoiceResource.setCreate_date(formatDateTimeForInvoice.format(invoice.getCreateDatetime()));
			// 請求書件名
			invoiceResource.setTitle(invoice.getInvoiceTitle());
			// 請求金額
			invoiceResource.setAmt(invoice.getInvoiceAmt());
			// 消費税
			invoiceResource.setTax(invoice.getTaxAmt());
			// 請求期間開始日
			invoiceResource.setStart_date(formatDateTimeForInvoice.format(invoice.getInvoiceStartDate()));
			// 請求期間終了日
			invoiceResource.setEnd_date(formatDateTimeForInvoice.format(invoice.getInvoiceEndDate()));
			// 備考
			invoiceResource.setNote(invoice.getInvoiceNote());

			// 顧客情報をまとめる
			if (!clientList.containsKey(invoice.getClientNo())) {
				clientResource = new ClientResource();

				// 顧客情報取得
				client = clientMstRepository.findOne(invoice.getClientNo());
				if (client == null) {
					// エラー処理
				}
				// 顧客管理番号
				clientResource.setNo(client.getClientNo());
				// 顧客担当者氏名（名字）
				clientResource.setCharge_last_name(client.getClientChargeLastName());
				// 顧客担当者氏名（名前）
				clientResource.setCharge_first_name(client.getClientChargeFirstName());
				// 法人名
				clientResource.setName(client.getClientName());
				// 住所
				clientResource.setAddress(client.getClientAddress());
				// 電話番号
				clientResource.setTel(client.getClientTel());
				// FAX
				clientResource.setFax(client.getClientFax());

				// リストに保持
				clientList.put(client.getClientNo(), clientResource);
			}
			// 顧客情報
			invoiceResource.setClient(clientList.get(invoice.getClientNo()));

			// リクエスト期間(取得用)
			Timestamp startDatetime = new Timestamp(formatDateTime.parse(invoice.getInvoiceStartDate() + " 00:00:00").getTime());
			Timestamp endDatetime = new Timestamp(formatDateTime.parse(invoice.getInvoiceEndDate() + " 23:59:59").getTime());

			orderList = orderRecordRepository.findByCreatePeriodAndClientNo(startDatetime, endDatetime, invoice.getClientNo());
			if (orderList == null) {
				// エラー処理
			}
			// 注文実績をまとめる
			orders = new ArrayList<OrderResource>();
			for (OrderRecord order : orderList) {
				orderResource = new OrderResource();

				// 注文管理番号
				orderResource.setOrder_no(order.getOrderNo());
				// 商品管理番号
				orderResource.setNo(order.getItemNo());
				// 商品名
				orderResource.setName(order.getItemName());
				// 商材区分
				orderResource.setType(order.getItemType());
				// 商品販売価格（税抜き）
				orderResource.setPrice(order.getItemPrice());
				// 購入数量
				orderResource.setCount(order.getItemCount());

				orders.add(orderResource);
			}
			// 注文実績個数
			invoiceResource.setItem_count(orders.size());
			// 注文実績
			invoiceResource.setItem(orders);

			invoiceResourceList.add(invoiceResource);
		}
		return invoiceResourceList;
	}


	/**
	 * Creates the invoice.
	 *
	 * @param request the request
	 * @return the regist response resource
	 * @throws Exception the exception
	 */
	@Transactional
	public RegistResponseResource createInvoice(RegistRequestResource request) throws Exception {

		// 現在日時取得
		Date currentTime = new Date(System.currentTimeMillis());

		// リクエスト期間(取得用)
		SimpleDateFormat formatDateTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Timestamp startDatetime = new Timestamp(formatDateTime.parse(request.getStartDate() + " 00:00:00").getTime());
		Timestamp endDatetime = new Timestamp(formatDateTime.parse(request.getEndDate() + " 23:59:59").getTime());
		// リクエスト期間(設定用)
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
		Timestamp startDate = new Timestamp(formatDate.parse(request.getStartDate()).getTime());
		Timestamp endDate = new Timestamp(formatDate.parse(request.getEndDate()).getTime());

		List<OrderRecord> orderList = new ArrayList<>();
		// 顧客番号の設定確認
		if (request.getClientNo() < 1) {
			// 注文実績取得（期間のみ）
			orderList = orderRecordRepository.findByCreatePeriod(startDatetime, endDatetime);
		} else {
			// 注文実績取得（期間と顧客番号）
			orderList = orderRecordRepository.findByCreatePeriodAndClientNo(startDatetime, endDatetime, request.getClientNo());
		}

		// 顧客管理番号リスト
		Map<Integer, Integer> clientList = new HashMap<Integer, Integer>();
		// 請求金額リスト
		Map<Integer, Integer> amtList = new HashMap<Integer, Integer>();
		// 請求書リスト
		List<Map<String, Integer>> invoiceNoList = new ArrayList<Map<String, Integer>>();
		Map<String, Integer> invoiceNoInfo = null;

		// 顧客情報ごとに注文実績をまとめる
		for (OrderRecord order : orderList) {
			// 顧客管理番号設定
			if (!clientList.containsKey(order.getClientNo())) {
				clientList.put(order.getClientNo(), order.getClientNo());
			}
			// 商品販売価格（税抜き）* 購入数量
			int amt = order.getItemPrice() * order.getItemCount();
			if (amtList.containsKey(order.getClientNo())) {
				amt += amtList.get(order.getClientNo());
				amtList.remove(order.getClientNo());
			}
			amtList.put(order.getClientNo(), amt);
		}

		// 顧客単位で請求書情報をまとめる
		for (Integer client : clientList.values()) {
			// 請求書情報格納用
			Invoice invoice = new Invoice();
			invoiceNoInfo = new HashMap<String, Integer>();

			// 顧客管理情報
			invoice.setClientNo(client);
			// 請求状態
			invoice.setInvoiceStatus("10");
			// 請求書作成日
			invoice.setInvoiceCreateDate(currentTime);
			// 請求書件名
			invoice.setInvoiceTitle(request.getTitle());
			// 請求金額
			invoice.setInvoiceAmt(amtList.get(client));
			// 消費税
			invoice.setTaxAmt((int)(amtList.get(client) * 0.08));
			// 請求期間開始日
			invoice.setInvoiceStartDate(startDate);
			// 請求期間終了日
			invoice.setInvoiceEndDate(endDate);
			// 備考
			invoice.setInvoiceNote(request.getNote());
			// 登録ユーザID
			invoice.setCreateUser("system");
			// 登録日時
			invoice.setCreateDatetime(currentTime);
			// 更新ユーザID
			invoice.setUpdateUser("system");
			// 更新日時
			invoice.setUpdateDatetime(currentTime);
			// 削除フラグ
			invoice.setDelFlg("0");

			// 請求書データ登録
			invoiceRepository.save(invoice);

			// 請求書No追加
			invoiceNoInfo.put("no", invoice.getInvoiceNo());
			invoiceNoList.add(invoiceNoInfo);
		}

		// 結果格納用
		RegistResponseResource response = new RegistResponseResource();
		response.setInvoice(invoiceNoList);
		response.setTotal_count(clientList.size());

		return response;
	}
}