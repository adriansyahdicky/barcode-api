package com.dicky.barcodeapi.repository;

import com.dicky.barcodeapi.entity.Mustahik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MustahikRepository extends JpaRepository<Mustahik, Integer>{

    Mustahik findByIdentitas(String identitas);

    @Query(value = "select count(*) from zis_mustahik where nama = null", nativeQuery = true)
    long findBynama();

}
