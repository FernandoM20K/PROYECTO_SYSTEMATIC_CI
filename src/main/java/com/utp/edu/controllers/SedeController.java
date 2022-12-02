package com.utp.edu.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.utp.edu.models.Sede;
import com.utp.edu.reports.SedeExportExcel;
import com.utp.edu.reports.SedesExportPDF;
import com.utp.edu.reports.SedesExportPDF2;
import com.utp.edu.services.EmailService;
import com.utp.edu.services.SedeService;

@RestController
@RequestMapping("/sede")
@CrossOrigin("*")

public class SedeController {
    
    @Autowired
    private SedeService sedeService;

    @Autowired
    private SedesExportPDF2 sedesExportPDF2;

    @Autowired
    private EmailService emailService;

    @PostMapping("/")
    public ResponseEntity<Sede> guardarSede(@RequestBody Sede sede) {
        return ResponseEntity.ok(sedeService.agregarSede(sede));
    }

    // @Autowired
    // public SedeController(SedesExportPDF2 sedesExportPDF2, EmailService emailService) {
    //     this.sedesExportPDF2 = sedesExportPDF2;
    //     this.emailService = emailService;
    // }

    @GetMapping("/")
    public ResponseEntity<?> listarSedes() {
        return ResponseEntity.ok(sedeService.obtenerSedes());
    }

    @GetMapping("/{sedeId}")
    public Sede listarSedePorId(@PathVariable("sedeId") Long sedeId) {
        return sedeService.obtenerSede(sedeId);
    }

    @PutMapping("/")
    public Sede actualizarSede(@RequestBody Sede sede) {
        return sedeService.actualizarSede(sede);
    }

    @DeleteMapping("/{sedeId}")
    public void eliminarSede(@PathVariable("sedeId") Long sedeId) {
        sedeService.eliminarSede(sedeId);
    }

    @GetMapping("/exportarPDF")
    public void exportarListadoPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormat.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Sedes_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        Set<Sede> sedes = sedeService.obtenerSedes();

        SedesExportPDF exporter = new SedesExportPDF(sedes);
        exporter.exportar(response);
    }

    @GetMapping("/exportarExcel")
    public void exportarListadoExcel(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/octec-stream");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormat.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Sedes_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);

        Set<Sede> sedes = sedeService.obtenerSedes();

        SedeExportExcel exporter = new SedeExportExcel(sedes);
        exporter.exportarExcel(response);
    }

    //TODO: NUEVO AGREGADO

    @GetMapping("/generarPdf")
    public void downloadPdf(HttpServletResponse response){
        try{
            Path file = Paths.get(sedesExportPDF2.generateSedesPdf().getAbsolutePath());
            if (Files.exists(file)){
                response.setContentType("application/pdf");
                response.addHeader("Content-Disposition", "attachment; filename"+ file.getFileName());
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/enviarMail")
    public void senPdfEmail() {
        this.emailService.sendListEmail("premiumagosto30@gmail.com");
    }

}
