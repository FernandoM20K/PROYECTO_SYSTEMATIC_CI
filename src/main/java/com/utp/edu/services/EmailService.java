package com.utp.edu.services;

import java.io.File;

import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.utp.edu.reports.ProfesorExportPDF2;
import com.utp.edu.reports.SedesExportPDF2;

@Service
@Transactional
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    SedesExportPDF2 sedesExportPDF2;

    //TODO: NUEVA LINEA 🔴🔴🔴🔴 
    @Autowired
    ProfesorExportPDF2 profesorExportPDF2;

    @Value("${spring.mail.username}")
    private String email;

    public void sendListEmail(String emailTo) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            File file = sedesExportPDF2.generateSedesPdf();
            helper.setFrom(email);
            helper.setTo(emailTo);
            helper.setSubject("Listado de Sedes");
            helper.setText("Reporte de Listado de Sedes");
            helper.addAttachment("Listado", file);
            javaMailSender.send(message);
        } catch (Exception e) {
            
        }
    }

    //TODO: NUEVA LINEA 🔴🔴🔴🔴 

    public void sendListProfesoresEmail(String emailTo) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            File file = profesorExportPDF2.generateProfesoresPdf();
            helper.setFrom(email); //TODO: Desde donde se envia
            helper.setTo(emailTo);//TODO: A quien se envia
            helper.setSubject("Listado Profesores");
            helper.setText("Reporte de Listado de Profesores");
            helper.addAttachment("Listado", file);
            javaMailSender.send(message);
        } catch (Exception e) {
            
        }
    }
}
