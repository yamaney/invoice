package web.java.middle.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.java.middle.invoice.dao.model.Invoice;

/**
 * The Interface InvoiceRepository.
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
