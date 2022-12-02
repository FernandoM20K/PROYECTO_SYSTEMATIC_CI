package com.utp.edu.reports;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.utp.edu.models.Sede;

public class SedeExportExcel {
    
    private XSSFWorkbook libro;
    private XSSFSheet hoja;

    private Set<Sede> listaSedes;

    public SedeExportExcel(Set<Sede> listaSedes) {
        this.listaSedes = listaSedes;
        libro = new XSSFWorkbook();
        hoja = libro.createSheet("Sedes");
    }

    private void excribirCabecera() {
        Row fila = hoja.createRow(0);
        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setBold(true);
        fuente.setFontHeight(16);
        estilo.setFont(fuente);

        Cell celda = fila.createCell(0);
        celda.setCellValue("ID");
        celda.setCellStyle(estilo);

        celda = fila.createCell(1);
        celda.setCellValue("NOMBRE");
        celda.setCellStyle(estilo);

        celda = fila.createCell(2);
        celda.setCellValue("DIRECCIÓN");
        celda.setCellStyle(estilo);

        celda = fila.createCell(3);
        celda.setCellValue("TELEFONO");
        celda.setCellStyle(estilo);
    }

    private void excribirDatosDeTablas() {
        int numeroFilas = 1;

        CellStyle estilo = libro.createCellStyle();
        XSSFFont fuente = libro.createFont();
        fuente.setFontHeight(14);
        estilo.setFont(fuente);

        for(Sede sede : listaSedes) {
            Row fila = hoja.createRow(numeroFilas ++);

            Cell celda = fila.createCell(0);
            celda.setCellValue(sede.getSedeId());
            hoja.autoSizeColumn(0);
            celda.setCellStyle(estilo);

            celda = fila.createCell(1);
            celda.setCellValue(sede.getNombre());
            hoja.autoSizeColumn(1);
            celda.setCellStyle(estilo);

            celda = fila.createCell(2);
            celda.setCellValue(sede.getDireccion());
            hoja.autoSizeColumn(2);
            celda.setCellStyle(estilo);

            celda = fila.createCell(3);
            celda.setCellValue(sede.getTelefono());
            hoja.autoSizeColumn(3);
            celda.setCellStyle(estilo);
        }
    }

    public void exportarExcel(HttpServletResponse response) throws IOException {
        excribirCabecera();
        excribirDatosDeTablas();

        ServletOutputStream outputStream = response.getOutputStream();
        libro.write(outputStream);
        libro.close();
        outputStream.close();
    }
}
