package com.dicky.barcodeapi.service;

import com.dicky.barcodeapi.entity.ChekPoint;

import java.util.List;

public interface ChekPointService {

    List<ChekPoint> findbyidParticipant(int idParticipant);

    //List<ChekPoint> findByIDParticipant(int idParticipant);

    ChekPoint findByIdParticipant(int idParticipant);

    ChekPoint updateChekpoint(ChekPoint chekPoint);

    ChekPoint findOneidParticipant(int idParticipant);

    ChekPoint insertChekpoint(ChekPoint chekPoint);

    ChekPoint findOneChekpoint(int id);

    List<ChekPoint> findBycheckScanAktif(int checkpointCounter);

    long scanAvailable();

    long scanScaned();

    long anonyMouse();

    ChekPoint findByidParticipant(int idParticipant);


}
