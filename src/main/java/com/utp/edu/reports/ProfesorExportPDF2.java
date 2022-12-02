package com.utp.edu.reports;

import java.io.File;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;

import org.springframework.core.io.ClassPathResource;
import org.thymeleaf.context.Context;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.utp.edu.models.Profesor;
import com.utp.edu.services.ProfesorService;

import java.io.*;

@Service
public class ProfesorExportPDF2 {

    private static final String PDF_RESOURCES = "/pdf-resources/";

    private SpringTemplateEngine springTemplateEngine; 

    private ProfesorService profesorService;

    @Autowired
    public ProfesorExportPDF2(SpringTemplateEngine springTemplateEngine, ProfesorService profesorService) {
        this.springTemplateEngine = springTemplateEngine;
        this.profesorService = profesorService;
    }

    public File generateProfesoresPdf() throws Exception{
        Context context = getContextProfesorListPdf();
        String html = loadAndFillTemplate(context);
        String xhtml = convertToXhtml(html);
        return renderProfesorListPdf(xhtml);
    }

    private String convertToXhtml(String html) throws UnsupportedEncodingException {
        Tidy tidy = new Tidy();
        tidy.setXHTML(true);
        tidy.setIndentContent(true);
        tidy.setPrintBodyOnly(true);
        tidy.setInputEncoding("UTF-8");
        tidy.setOutputEncoding("UTF-8");
        tidy.setSmartIndent(true);
        tidy.setShowWarnings(false);
        tidy.setQuiet(true);
        tidy.setTidyMark(false);

        Document htmlDOM = tidy.parseDOM(new ByteArrayInputStream(html.getBytes()), null);

        OutputStream out = new ByteArrayOutputStream();
        tidy.pprint(htmlDOM, out);
        return out.toString();
    }

    private File renderProfesorListPdf(String html) throws Exception {
        File file = File.createTempFile("profesores", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer(20f * 4f / 3f, 20);
        renderer.setDocumentFromString(html, new ClassPathResource(PDF_RESOURCES).getURL().toExternalForm());
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        file.deleteOnExit();
        return file;
    }

    private Context getContextProfesorListPdf() {
        Set<Profesor> profesores = this.profesorService.obtenerProfesores();
        Context context = new Context();
        context.setVariable("profesores", profesores);
        return context;
    }
    
    private String loadAndFillTemplate(Context context) {
        return springTemplateEngine.process("profesoresPDF", context);
    }
}
