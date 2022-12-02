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
import com.utp.edu.models.Profesor;
import com.utp.edu.reports.ProfesorExportExcel;
import com.utp.edu.reports.ProfesorExportPDF2;
import com.utp.edu.reports.ProfesoresExportPDF;
import com.utp.edu.services.EmailService;
import com.utp.edu.services.ProfesorService;

@RestController
@RequestMapping("/profesor")
@CrossOrigin("*")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @Autowired
    private ProfesorExportPDF2 profesorExportPDF2;

    @Autowired
    private EmailService emailService;

    @PostMapping("/")
    public ResponseEntity<Profesor> guardarProfesor(@RequestBody Profesor profesor) {
        return ResponseEntity.ok(profesorService.agregarProfesor(profesor));
    }

    @GetMapping("/")
    public ResponseEntity<?> listarProfesores() {
        return ResponseEntity.ok(profesorService.obtenerProfesores());
    }

    @GetMapping("/{profesorId}")
    public Profesor listaProfesorPorId(@PathVariable("profesorId") Long profesorId) {
        return profesorService.obteneProfesor(profesorId);
    }

    @PutMapping("/")
    public Profesor actualizaProfesor(@RequestBody Profesor profesor) {
        return profesorService.actualizarProfesor(profesor);
    }

    @DeleteMapping("/{profesorId}")
    public void eliminarProfesor(@PathVariable("profesorId") Long profesorId) {
        profesorService.eliminarProfesor(profesorId);
    }

    //TODO: NO SE CUENTA
    @GetMapping("/exportarPDF")
    public void exportarListadoPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormat.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Profesores_" + fechaActual + ".pdf";

        response.setHeader(cabecera, valor);

        Set<Profesor> profesores = profesorService.obtenerProfesores();

        ProfesoresExportPDF exporter = new ProfesoresExportPDF(profesores);
        exporter.exportar(response);
    }

    @GetMapping("/generarPdf") //TODO: Haciendo esta peticion nos genera un PDF
    public void downloadPdf(HttpServletResponse response){
        try{
            Path file = Paths.get(profesorExportPDF2.generateProfesoresPdf().getAbsolutePath());
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

    @GetMapping("/exportarExcel")
    public void exportarListadoExcel(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/octec-stream");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String fechaActual = dateFormat.format(new Date());

        String cabecera = "Content-Disposition";
        String valor = "attachment; filename=Profesores_" + fechaActual + ".xlsx";

        response.setHeader(cabecera, valor);

        Set<Profesor> profesores = profesorService.obtenerProfesores();

        ProfesorExportExcel exporter = new ProfesorExportExcel(profesores);
        exporter.exportarExcel(response);
    }

    @GetMapping("/enviarMail")
    public void senPdfEmail() {
        this.emailService.sendListProfesoresEmail("premiumagosto30@gmail.com");
    }
    
}
