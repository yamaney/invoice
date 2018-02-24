package web.java.middle.invoice.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Class InvoiceApiApplication.
 */
@SpringBootApplication(scanBasePackages={"web.java.middle.invoice"})
public class InvoiceApiApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(InvoiceApiApplication.class, args);
	}
}
