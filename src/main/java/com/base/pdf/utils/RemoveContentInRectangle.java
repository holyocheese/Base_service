package com.base.pdf.utils;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.pdfcleanup.PdfCleanUpLocation;
import com.itextpdf.pdfcleanup.PdfCleanUpTool;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class RemoveContentInRectangle {
    public static final String DEST =  "D:/cheese python/huxi2/0000000.pdf";

    public static final String SRC = "D:/cheese python/huxi2/0test.pdf";

    public static void main(String[] args) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new RemoveContentInRectangle().manipulatePdf(SRC,DEST, new Rectangle(79, 47, 61, 10));
    }

    protected void manipulatePdf(String src,String dest,Rectangle rect) throws IOException {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), new PdfWriter(dest));

        List<PdfCleanUpLocation> cleanUpLocations = new ArrayList<PdfCleanUpLocation>();

        // The arguments of the PdfCleanUpLocation constructor: the number of page to be cleaned up,
        // a Rectangle defining the area on the page we want to clean up,
        // a color which will be used while filling the cleaned area.
        PdfCleanUpLocation location = new PdfCleanUpLocation(1, new Rectangle(79, 760, 100, 40),
                ColorConstants.GRAY);
        cleanUpLocations.add(location);

        PdfCleanUpTool cleaner = new PdfCleanUpTool(pdfDoc, cleanUpLocations);
        cleaner.cleanUp();

        pdfDoc.close();
    }
}
