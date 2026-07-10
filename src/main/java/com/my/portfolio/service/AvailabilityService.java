package com.my.portfolio.service;

import com.my.portfolio.model.Availability;
import com.my.portfolio.repository.AvailabilityRepository;
import org.springframework.stereotype.Service;

@Service
public class AvailabilityService {

    private static final Long SINGLETON_ID = 1L;

    private final AvailabilityRepository repository;

    public AvailabilityService(AvailabilityRepository repository) {
        this.repository = repository;
    }

    public boolean isAvailable() {
        return repository.findById(SINGLETON_ID)
                .map(Availability::isAvailable)
                .orElse(true); // sensible default if the row hasn't been seeded yet
    }

    public boolean updateAvailability(boolean available) {
        Availability row = repository.findById(SINGLETON_ID)
                .orElseGet(() -> {
                    Availability a = new Availability();
                    a.setId(SINGLETON_ID);
                    return a;
                });
        row.setAvailable(available);
        return repository.save(row).isAvailable();
    }

    public Long getYop() {
        return repository.findById(SINGLETON_ID)
                .map(Availability::getYop)
                .orElse(0L);
    }

    public Long getProductionApis() {
        return repository.findById(SINGLETON_ID)
                .map(Availability::getProductionApis)
                .orElse(0L);
    }
}