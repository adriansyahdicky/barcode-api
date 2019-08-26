package com.dicky.barcodeapi.service;

import com.dicky.barcodeapi.entity.Koordinator;
import com.dicky.barcodeapi.repository.KoordinatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class KoordinatorServiceImpl implements KoordinatorService{

    @Autowired
    private KoordinatorRepository koordinatorRepository;

    @Override
    public Koordinator insertKoordinator(Koordinator koordinator) {
        return koordinatorRepository.save(koordinator);
    }

    @Override
    public Koordinator getById(int id) {
        return koordinatorRepository.findOne(id);
    }
}
