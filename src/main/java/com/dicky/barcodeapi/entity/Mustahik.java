package com.dicky.barcodeapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "zis_mustahik")
public class Mustahik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nama;

    private String tempat_lahir;

    private Date tgl_lahir;

    private String identitas;

    private String alamat;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "koordinator", nullable = false)
    private Koordinator koordinator;

    private int verified;

    private String no_form;

    private int ring;

    private Date tgl_survey;

    private int surveyor;

    private int hasil_survey;

    @OneToMany(mappedBy = "mustahik", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<ChekPoint> chekPoints = new ArrayList<>();

    private String rt;

    private String rw;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTempat_lahir() {
        return tempat_lahir;
    }

    public void setTempat_lahir(String tempat_lahir) {
        this.tempat_lahir = tempat_lahir;
    }

    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getIdentitas() {
        return identitas;
    }

    public void setIdentitas(String identitas) {
        this.identitas = identitas;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

//    public int getKoordinator() {
//        return koordinator;
//    }
//
//    public void setKoordinator(int koordinator) {
//        this.koordinator = koordinator;
//    }


    public Koordinator getKoordinator() {
        return koordinator;
    }

    public void setKoordinator(Koordinator koordinator) {
        this.koordinator = koordinator;
    }

    public int getVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }

    public String getNo_form() {
        return no_form;
    }

    public void setNo_form(String no_form) {
        this.no_form = no_form;
    }

    public int getRing() {
        return ring;
    }

    public void setRing(int ring) {
        this.ring = ring;
    }

    public Date getTgl_survey() {
        return tgl_survey;
    }

    public void setTgl_survey(Date tgl_survey) {
        this.tgl_survey = tgl_survey;
    }

    public int getSurveyor() {
        return surveyor;
    }

    public void setSurveyor(int surveyor) {
        this.surveyor = surveyor;
    }

    public int getHasil_survey() {
        return hasil_survey;
    }

    public void setHasil_survey(int hasil_survey) {
        this.hasil_survey = hasil_survey;
    }

    public List<ChekPoint> getChekPoints() {
        return chekPoints;
    }

    public void setChekPoints(List<ChekPoint> chekPoints) {
        this.chekPoints = chekPoints;
    }

    public String getRt() {
        return rt;
    }

    public void setRt(String rt) {
        this.rt = rt;
    }

    public String getRw() {
        return rw;
    }

    public void setRw(String rw) {
        this.rw = rw;
    }
}
