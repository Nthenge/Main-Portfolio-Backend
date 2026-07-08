package com.my.portfolio.repository;

import com.my.portfolio.model.ServiceOffering;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceOfferingRepository extends JpaRepository<ServiceOffering, Long> {
    List<ServiceOffering> findAllByOrderBySortOrderAsc();
}
