package com.utp.edu.reports;

import java.awt.Color;
import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.utp.edu.models.Profesor;

public class ProfesoresExportPDF {
    
    private Set<Profesor> listaProfesores;

    public ProfesoresExportPDF(Set<Profesor> listaProfesores) {
        this.listaProfesores = listaProfesores;
    }

    private void escribirCabeceraTabla(PdfPTable tabla) {
        PdfPCell celda = new PdfPCell();
        celda.setBackgroundColor(Color.BLUE);
        celda.setPadding(5);
        Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
        fuente.setColor(Color.WHITE);

        celda.setPhrase(new Phrase("ID", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("NOMBRE", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("APELLIDO", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("DNI", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("CELULAR", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("SUELDO", fuente));
        tabla.addCell(celda);

        celda.setPhrase(new Phrase("EMAIL", fuente));
        tabla.addCell(celda);
    }

    private void escribirDatosTablas(PdfPTable tabla) {
        for (Profesor profesor : listaProfesores) {
            tabla.addCell(String.valueOf(profesor.getProfesorId()));
            tabla.addCell(profesor.getNombre());
            tabla.addCell(profesor.getApellido());
            tabla.addCell(profesor.getDni());
            tabla.addCell(profesor.getCelular());
            tabla.addCell(String.valueOf(profesor.getSueldo()));
            tabla.addCell(profesor.getEmail());
        }
    }

    public void exportar(HttpServletResponse response) throws DocumentException, IOException {
        Document documento = new Document(PageSize.A4.rotate());
        PdfWriter.getInstance(documento, response.getOutputStream());

        documento.open();

        Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fuente.setColor(Color.BLUE);
        fuente.setSize(18);

        Paragraph titulo = new Paragraph("Lista de Profesores", fuente);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        documento.add(titulo);

        PdfPTable tabla = new PdfPTable(7);
        tabla.setWidthPercentage(90);
        tabla.setSpacingBefore(15);
        tabla.setWidths(new float[] {1f,2.8f,2.8f,2f,2.4f,2.5f,5.5f});
        tabla.setWidthPercentage(100);

        escribirCabeceraTabla(tabla);
        escribirDatosTablas(tabla);

        documento.add(tabla);
        documento.close();
    }
}
