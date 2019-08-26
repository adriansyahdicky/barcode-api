package com.dicky.barcodeapi.service;

import com.dicky.barcodeapi.entity.ChekPoint;
import com.dicky.barcodeapi.repository.ChekpointRepository;
import com.dicky.barcodeapi.request.RequestDataScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckPointServiceImpl implements ChekPointService{

    @Autowired private ChekpointRepository chekpointRepository;

    @Override
    public ChekPoint findByidParticipant(int idParticipant) {
        //return chekpointRepository.findByidParticipant(idParticipant);
        return null;
    }

    @Override
    public List<ChekPoint> findbyidParticipant(int idParticipant) {
        return chekpointRepository.findbyidParticipant(idParticipant);
    }

    @Override
    public ChekPoint updateChekpoint(ChekPoint chekPoint) {

        return chekpointRepository.save(chekPoint);
    }

    @Override
    public ChekPoint findOneidParticipant(int idParticipant) {
        //return chekpointRepository.findOneidParticipant(idParticipant);
        return null;
    }

    @Override
    public ChekPoint findByIdParticipant(int idParticipant) {
        return chekpointRepository.findByIdParticipant(idParticipant);
    }

    @Override
    public ChekPoint insertChekpoint(ChekPoint chekPoint) {

        return chekpointRepository.save(chekPoint);
    }

    @Override
    public ChekPoint findOneChekpoint(int id) {

        return chekpointRepository.findOne(id);
    }

    @Override
    public List<ChekPoint> findBycheckScanAktif(int checkpointCounter) {
        //return chekpointRepository.findBycheckScanAktif(checkpointCounter);
        return null;
    }

    @Override
    public long scanAvailable() {
        return chekpointRepository.scanAvailable();
    }

    @Override
    public long anonyMouse() {
        return chekpointRepository.anonyMouse();
    }


    @Override
    public long scanScaned() {
        return chekpointRepository.scanScaned();
    }

//    @Override
//    public List<ChekPoint> findByIDParticipant(int idParticipant) {
//        return chekpointRepository.findByIDParticipant(idParticipant);
//    }
}

