package com.praca.manager.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class PdfService {

    public void newDocument() throws DocumentException, FileNotFoundException {
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Lenovo/Desktop/new.pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk("hey hi hello", font);

        document.add(chunk);
        document.close();
    }

}
