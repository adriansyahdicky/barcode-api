package com.dicky.barcodeapi.service;

import com.dicky.barcodeapi.entity.Koordinator;

public interface KoordinatorService {

    Koordinator insertKoordinator(Koordinator koordinator);

    Koordinator getById(int id);

}
