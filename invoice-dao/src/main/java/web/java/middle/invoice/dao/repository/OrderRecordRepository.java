package web.java.middle.invoice.dao.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import web.java.middle.invoice.dao.model.OrderRecord;

/**
 * The Interface OrderRepository.
 */
@Repository
public interface OrderRecordRepository extends JpaRepository<OrderRecord, Integer> {

	/**
	 * Find by create period.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the list
	 */
	@Query("SELECT order "
			+ "FROM OrderRecord order "
			+ "WHERE order.createDatetime BETWEEN :startDate AND :endDate "
			+ "AND order.delFlg = '0'")
	public List<OrderRecord> findByCreatePeriod(
		@Param("startDate") Timestamp startDate,
		@Param("endDate") Timestamp endDate
	);

	/**
	 * Find by create period and client no.
	 *
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param clientNo the client no
	 * @return the list
	 */
	@Query("SELECT order "
			+ "FROM OrderRecord order "
			+ "WHERE order.createDatetime BETWEEN :startDate AND :endDate "
			+ "AND order.clientNo = :clientNo AND order.delFlg = '0'")
	public List<OrderRecord> findByCreatePeriodAndClientNo(
		@Param("startDate") Timestamp startDate,
		@Param("endDate") Timestamp endDate,
		@Param("clientNo") int clientNo
	);
}
