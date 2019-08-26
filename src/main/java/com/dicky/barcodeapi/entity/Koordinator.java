package com.dicky.barcodeapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "para_koordinator")
public class Koordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Nama;

    private String Phone;

    private String Lokasi;

    private String Mesjid;

    @OneToMany(mappedBy = "koordinator", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Mustahik> mustahiks = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getLokasi() {
        return Lokasi;
    }

    public void setLokasi(String lokasi) {
        Lokasi = lokasi;
    }

    public String getMesjid() {
        return Mesjid;
    }

    public void setMesjid(String mesjid) {
        Mesjid = mesjid;
    }
}
