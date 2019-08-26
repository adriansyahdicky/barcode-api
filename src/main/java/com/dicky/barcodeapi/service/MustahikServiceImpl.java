package com.dicky.barcodeapi.service;

import com.dicky.barcodeapi.entity.Mustahik;
import com.dicky.barcodeapi.repository.MustahikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MustahikServiceImpl implements MustahikService{

    @Autowired
    private MustahikRepository mustahikRepository;

    @Override
    public long findBynama() {
        return mustahikRepository.findBynama();
    }

    @Override
    public Mustahik findByIdentitas(String identitas) {
        return mustahikRepository.findByIdentitas(identitas);
    }

    @Override
    public Mustahik insertMustahik(Mustahik mustahik) {
        return mustahikRepository.save(mustahik);
    }
}
