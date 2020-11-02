package com.base.pdf.utils;

import com.itextpdf.kernel.pdf.PdfDictionary;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfObject;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfStream;
import com.itextpdf.kernel.pdf.PdfWriter;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class ReplacePdfObject {

	public static final String DEST = "D:/cheese python/huxi2/00000.pdf";
    public static final String SRC = "D:/cheese python/huxi2/0test.pdf";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new ReplacePdfObject().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(dest));
        PdfPage page = pdfDoc.getFirstPage();
        System.out.println(page.getContentStreamCount());
        PdfDictionary dict = page.getPdfObject();
        

        PdfObject object = dict.get(PdfName.Contents);
        if (object instanceof PdfStream) {
        	System.out.println(object);
            PdfStream stream = (PdfStream) object;
            byte[] data = stream.getBytes();
            String replacedData = new String(data).replace("11330963", "12312312");
            stream.setData(replacedData.getBytes(StandardCharsets.UTF_8));
        }

        pdfDoc.close();
    }
}
