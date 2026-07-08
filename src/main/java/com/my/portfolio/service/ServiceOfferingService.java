package com.my.portfolio.service;

import com.my.portfolio.dto.ServiceOfferingRequest;
import com.my.portfolio.model.ServiceOffering;
import com.my.portfolio.repository.ServiceOfferingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOfferingService {

    private final ServiceOfferingRepository repository;

    public ServiceOfferingService(ServiceOfferingRepository repository) {
        this.repository = repository;
    }

    public List<ServiceOffering> getAllServices() {
        return repository.findAllByOrderBySortOrderAsc();
    }

    public ServiceOffering createService(ServiceOfferingRequest request) {
        ServiceOffering offering = new ServiceOffering();
        offering.setNumber(request.number());
        offering.setTitle(request.title());
        offering.setSubtitle(request.subtitle());
        offering.setWide(request.wide());
        offering.setSortOrder(request.sortOrder());
        return repository.save(offering);
    }
}
