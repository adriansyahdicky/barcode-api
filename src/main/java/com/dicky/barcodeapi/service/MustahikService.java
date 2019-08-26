package com.dicky.barcodeapi.service;

import com.dicky.barcodeapi.entity.Mustahik;

public interface MustahikService {

    long findBynama();

    Mustahik findByIdentitas(String identitas);

    Mustahik insertMustahik(Mustahik mustahik);

}
