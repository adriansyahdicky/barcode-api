package com.dicky.barcodeapi.controller;

import com.dicky.barcodeapi.entity.ChekPoint;
import com.dicky.barcodeapi.entity.Koordinator;
import com.dicky.barcodeapi.entity.Mustahik;
import com.dicky.barcodeapi.exception.QrCodeCheckPointException;
import com.dicky.barcodeapi.request.RequestDataScan;
import com.dicky.barcodeapi.response.ResponseMessage;
import com.dicky.barcodeapi.service.ChekPointService;
import com.dicky.barcodeapi.service.KoordinatorService;
import com.dicky.barcodeapi.service.MustahikService;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/api/qrcode")
public class ParaMemberController {

    @Autowired
    private ChekPointService chekPointService;


    @Autowired private MustahikService mustahikService;

    @Autowired private KoordinatorService koordinatorService;

    private ResponseMessage message=new ResponseMessage();


    @GetMapping(value = "/member/{idParticipant}")
    public ChekPoint getStatus(@PathVariable int idParticipant){
       ChekPoint chekPoint = chekPointService.findByIdParticipant(idParticipant);
       if (chekPoint == null){
           throw new QrCodeCheckPointException("ID Participant tidak ditemukan");
       }

       return chekPoint;

    }

    @GetMapping("/{value}")
    public ResponseEntity<String> generateBarcode(@PathVariable String value, HttpServletResponse response){
        try {
            ByteArrayOutputStream out = QRCode.from(value)
                    .to(ImageType.PNG).stream();
            response.setContentType("image/png");
            response.setContentLength(out.size());
            OutputStream outStream = response.getOutputStream();

            outStream.write(out.toByteArray());

            outStream.flush();
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<String>(value, HttpStatus.OK);
    }

    @PutMapping(value = "/updateQrcode/{idParticipant}")
    public ResponseEntity<ChekPoint>updateChekPoint(@PathVariable int idParticipant){

        ChekPoint currentcheck = chekPointService.findByIdParticipant(idParticipant);
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        String dateformat = format.format(new Date());
        if(currentcheck == null){
            message.setMessage("Data Qrcode ini tidak ada");
            throw new QrCodeCheckPointException(message.getMessage());
        }
        else if(chekPointService.findbyidParticipant(idParticipant).isEmpty()){
            message.setMessage("QR Code ini sudah tidak aktif");
            throw new QrCodeCheckPointException(message.getMessage());
        }
//        else if(!chekPointService.findByIDParticipant(idParticipant).isEmpty()){
//            message.setMessage("QR Code ini sudah tidak aktif");
//            throw new QrCodeCheckPointException(message.getMessage());
//        }
        else if(currentcheck.getMustahik().getId() == 2694 || currentcheck.getMustahik().getId() == 2696){
            int tambah = currentcheck.getCheckpointCounter();
            tambah+=1;
            currentcheck.setCheckpointCounter(tambah);
            currentcheck.setScan_data(dateformat);
        }
        else if(currentcheck.getMustahik().getId() != 2694 || currentcheck.getMustahik().getId() != 2696){
            currentcheck.setCheckpointCounter(1);
            currentcheck.setScan_data(dateformat);
        }

        chekPointService.updateChekpoint(currentcheck);
        return new ResponseEntity<ChekPoint>(currentcheck, HttpStatus.OK);
    }


    @GetMapping(value = "/scanAvailable")
    public RequestDataScan scanAvailable(){
        long data = chekPointService.scanAvailable();
        RequestDataScan dataScan = new RequestDataScan();
        dataScan.setCheckpointCounter((int) data);
        return dataScan;

    }

    @GetMapping(value = "/scanScaned")
    public RequestDataScan scanScaned(){
        long data = chekPointService.scanScaned();
        RequestDataScan dataScan = new RequestDataScan();
        dataScan.setCheckpointCounter((int) data);
        return dataScan;

    }

    @GetMapping(value = "/findBynama")
    public RequestDataScan findBynama(){
        long data = mustahikService.findBynama();
        RequestDataScan dataScan = new RequestDataScan();
        dataScan.setCheckpointCounter((int) data);
        return dataScan;
    }

    @GetMapping(value = "/anonyMouse")
    public RequestDataScan anonyMouse(){
        long data = chekPointService.anonyMouse();
        RequestDataScan dataScan = new RequestDataScan();
        dataScan.setCheckpointCounter((int) data);
        return dataScan;
    }


    @PostMapping(value = "/createmember")
    public ResponseEntity<Mustahik> insertChekpoint(@RequestBody Mustahik request){
        Mustahik m = mustahikService.findByIdentitas(request.getIdentitas());
        Mustahik mustahik;
        Koordinator k;
        if(m != null){
            throw new QrCodeCheckPointException("identitas sudah ada");
        }else{
            String pattern = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            String dateformat = format.format(new Date());

            request.setTgl_survey(new Date());
            request.setTgl_lahir(new Date());

            k = koordinatorService.getById(1);
            request.setKoordinator(k);

            mustahik = mustahikService.insertMustahik(request);

            ChekPoint c = new ChekPoint();
            c.setMustahik(mustahik);
            c.setCreatedDate(new Date());
            c.setCheckpointCounter(1);
            c.setIdEvent("SYSTEM");
            c.setScan_data(dateformat);

            chekPointService.insertChekpoint(c);

        }
        return new ResponseEntity<Mustahik>(mustahik, HttpStatus.OK);
    }




}
