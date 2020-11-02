package com.base.pdf.utils;

import java.io.File;
import java.io.IOException;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;

public class ExtractStreams {
	
	public static final String DEST = "D:/cheese python/huxi2/00000.pdf";
    public static final String SRC = "D:/cheese python/huxi2/0test.pdf";


    public static void before() {
        new File(DEST).getParentFile().mkdirs();
    }

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.mkdirs();

        new ExtractStreams().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws IOException {
    	PdfReader reader = new PdfReader(SRC);
        PdfDocument pdfDocument = new PdfDocument(reader, new PdfWriter(DEST));

        
        pdfDocument.close();
    }
}