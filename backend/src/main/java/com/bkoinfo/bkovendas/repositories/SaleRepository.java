package com.bkoinfo.bkovendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bkoinfo.bkovendas.dto.SaleSuccessDTO;
import com.bkoinfo.bkovendas.dto.SaleSumDTO;
import com.bkoinfo.bkovendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	@Query("SELECT new com.bkoinfo.bkovendas.dto.SaleSumDTO(obj.seller, SUM(obj.amount))" 
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupBySeller();
	
	@Query("SELECT new com.bkoinfo.bkovendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals))" 
			+ " FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
}
