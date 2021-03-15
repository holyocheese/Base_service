package com.base.dao.pdf.entity;

import javax.persistence.*;

@Table(name = "pdf_area")
public class PdfArea {
    @Column(name = "pdf_set_name")
    private String pdfSetName;

    @Column(name = "y_begin")
    private Float yBegin;

    @Column(name = "y_end")
    private Float yEnd;

    @Column(name = "x_begin")
    private Float xBegin;

    @Column(name = "x_end")
    private Float xEnd;

    @Column(name = "area_type")
    private String areaType;

    @Column(name = "table_data_type")
    private String tableDataType;

    /**
     * @return pdf_set_name
     */
    public String getPdfSetName() {
        return pdfSetName;
    }

    /**
     * @param pdfSetName
     */
    public void setPdfSetName(String pdfSetName) {
        this.pdfSetName = pdfSetName;
    }

    /**
     * @return y_begin
     */
    public Float getyBegin() {
        return yBegin;
    }

    /**
     * @param yBegin
     */
    public void setyBegin(Float yBegin) {
        this.yBegin = yBegin;
    }

    /**
     * @return y_end
     */
    public Float getyEnd() {
        return yEnd;
    }

    /**
     * @param yEnd
     */
    public void setyEnd(Float yEnd) {
        this.yEnd = yEnd;
    }

    /**
     * @return x_begin
     */
    public Float getxBegin() {
        return xBegin;
    }

    /**
     * @param xBegin
     */
    public void setxBegin(Float xBegin) {
        this.xBegin = xBegin;
    }

    /**
     * @return x_end
     */
    public Float getxEnd() {
        return xEnd;
    }

    /**
     * @param xEnd
     */
    public void setxEnd(Float xEnd) {
        this.xEnd = xEnd;
    }

    /**
     * @return area_type
     */
    public String getAreaType() {
        return areaType;
    }

    /**
     * @param areaType
     */
    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    /**
     * @return table_data_type
     */
    public String getTableDataType() {
        return tableDataType;
    }

    /**
     * @param tableDataType
     */
    public void setTableDataType(String tableDataType) {
        this.tableDataType = tableDataType;
    }
}