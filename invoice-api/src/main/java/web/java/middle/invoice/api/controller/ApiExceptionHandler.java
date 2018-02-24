package web.java.middle.invoice.api.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import web.java.middle.invoice.api.resource.InvoiceApiErrorResource;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	private InvoiceApiErrorResource createApiError(Exception ex) {
		InvoiceApiErrorResource apiError = new InvoiceApiErrorResource();
		apiError.setMessage(ex.getMessage());
		return apiError;
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
		InvoiceApiErrorResource apiError = createApiError(ex);
		return super.handleExceptionInternal(ex, apiError, headers, status, request);
	}
}