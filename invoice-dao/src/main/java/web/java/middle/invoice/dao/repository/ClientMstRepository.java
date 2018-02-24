package web.java.middle.invoice.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.java.middle.invoice.dao.model.ClientMst;

/**
 * The Interface ClientRepository.
 */
@Repository
public interface ClientMstRepository extends JpaRepository<ClientMst, Integer> {

}
