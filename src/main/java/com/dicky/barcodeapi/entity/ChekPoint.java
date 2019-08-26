package com.dicky.barcodeapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "qrcode_checkpoint")
public class ChekPoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParticipant;

    private String idEvent;

    private Date createdDate;

    private int checkpointCounter;


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_member", nullable = false)
//    private ParaMember paraMember;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", nullable = false)
    private Mustahik mustahik;

    private String scan_data;

    private String event_param_1;

    public int getIdParticipant() {
        return idParticipant;
    }

    public void setIdParticipant(int idParticipant) {
        this.idParticipant = idParticipant;
    }


    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getCheckpointCounter() {
        return checkpointCounter;
    }

    public void setCheckpointCounter(int checkpointCounter) {
        this.checkpointCounter = checkpointCounter;
    }

    public String getScan_data() {
        return scan_data;
    }

    public void setScan_data(String scan_data) {
        this.scan_data = scan_data;
    }

//    public ParaMember getParaMember() {
//        return paraMember;
//    }
//
//    public void setParaMember(ParaMember paraMember) {
//        this.paraMember = paraMember;
//    }


    public Mustahik getMustahik() {
        return mustahik;
    }

    public void setMustahik(Mustahik mustahik) {
        this.mustahik = mustahik;
    }

    public String getEvent_param_1() {
        return event_param_1;
    }

    public void setEvent_param_1(String event_param_1) {
        this.event_param_1 = event_param_1;
    }
}
