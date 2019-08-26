package com.dicky.barcodeapi.repository;

import com.dicky.barcodeapi.entity.ChekPoint;
import com.dicky.barcodeapi.request.RequestDataScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ChekpointRepository extends JpaRepository<ChekPoint, Integer>{


    @Query(value = "select * from qrcode_checkpoint where id_participant = ?1 and checkpoint_counter >= 0 and (id != 2696 or id != 2694) ", nativeQuery = true)
    List<ChekPoint> findbyidParticipant(int idParticipant);

//    @Query(value = "select * from qrcode_checkpoint where id_participant = ?1 and checkpoint_counter >= 0 and id != 2694 ", nativeQuery = true)
//    List<ChekPoint> findByIDParticipant(int idParticipant);

//    ChekPoint findByidParticipant(int idParticipant);
//
//    @Query(value = "select * from qrcode_checkpoint where id_participant like %?1", nativeQuery = true)
//    List<ChekPoint> findByIDParticipant(int idParticipant);
//
//    @Query(value = "select * from qrcode_checkpoint where CAST(id_participant AS TEXT) like %?1", nativeQuery = true)
//    ChekPoint findOneidParticipant(int idParticipant);
//
//    //ini ga pake query
//    ChekPoint findByIdParticipant(int idParicipant);
//
//    @Query(value = "select * from qrcode_checkpoint where CAST(id_participant AS TEXT) like %?1 and checkpoint_counter = 0", nativeQuery = true)
//    List<ChekPoint> findBycheckScanAktif(int checkpointCounter);
//
//
//
    @Query(value = "SELECT count(*) FROM qrcode_checkpoint where checkpoint_counter = 0", nativeQuery = true)
    long scanAvailable();

    @Query(value = "SELECT sum(coalesce(checkpoint_counter, 0)) FROM qrcode_checkpoint", nativeQuery = true)
    long scanScaned();

    @Query(value = "SELECT count(*) FROM qrcode_checkpoint where checkpoint_counter >= 1 and (id != 2694 or id != 2696)", nativeQuery = true)
    long anonyMouse();

//    @Query(value = "select c from ChekPoint c inner join c.mustahik m inner join m.koordinator where c.idParticipant = ?")
//    ChekPoint findByIdParticipant(int idParticipant);

    @Query(value = "select qc.*, zm.*, pk.* from qrcode_checkpoint qc inner join zis_mustahik zm on(qc.id=zm.id) inner join para_koordinator pk on(pk.id=zm.koordinator) where qc.id_participant = ?", nativeQuery = true)
    ChekPoint findByIdParticipant(int idParticipant);
}
