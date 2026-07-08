package com.my.portfolio.controller;

import com.my.portfolio.dto.ServiceOfferingRequest;
import com.my.portfolio.model.ServiceOffering;
import com.my.portfolio.service.ServiceOfferingService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class ServiceOfferingController {

    private final ServiceOfferingService service;

    public ServiceOfferingController(ServiceOfferingService service) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceOffering> getServices() {
        return service.getAllServices();
    }

    @PostMapping
    public ServiceOffering createService(@Valid @RequestBody ServiceOfferingRequest request) {
        return service.createService(request);
    }
}
