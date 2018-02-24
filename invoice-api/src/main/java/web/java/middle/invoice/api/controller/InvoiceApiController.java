package web.java.middle.invoice.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import web.java.middle.invoice.api.resource.InvoiceListResource;
import web.java.middle.invoice.api.resource.RegistRequestResource;
import web.java.middle.invoice.api.resource.RegistResponseResource;
import web.java.middle.invoice.api.service.InvoiceService;

/**
 * The Class InvoiceApiController.
 */
@RestController
@RequestMapping("/invoice-api/invoices")
@Validated
public class InvoiceApiController {

	/** The invoice service. */
	@Autowired
	InvoiceService invoiceService;

	/**
	 * Gets the invoice list.
	 *
	 * @return the invoice list
	 * @throws Exception the exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	public InvoiceListResource getInvoiceList() throws Exception {
		return invoiceService.getInvoiceAll();
	}

	/**
	 * Gets the invoice info.
	 *
	 * @param invoiceNo the invoice no
	 * @return the invoice info
	 * @throws Exception the exception
	 */
	@RequestMapping(path = "{invoiceNo}", method = RequestMethod.GET)
	public InvoiceListResource getInvoiceInfo(@PathVariable int invoiceNo) throws Exception {
		return invoiceService.getInvoiceInfo(invoiceNo);
	}

	/**
	 * Creates the invoice.
	 *
	 * @param request the request
	 * @return the string
	 * @throws Exception the exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public RegistResponseResource createInvoice(@Validated @RequestBody RegistRequestResource request) throws Exception {
		RegistResponseResource response = invoiceService.createInvoice(request);
		return response;
	}
}
