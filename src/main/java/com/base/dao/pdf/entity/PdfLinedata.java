package com.base.dao.pdf.entity;

import javax.persistence.*;

@Table(name = "pdf_linedata")
public class PdfLinedata {
    @Id
    private Integer id;

    @Column(name = "pdf_id")
    private Integer pdfId;

    @Column(name = "y_begin")
    private Float yBegin;

    @Column(name = "x_begin")
    private Float xBegin;

    @Column(name = "x_end")
    private Float xEnd;

    private String text;

    @Column(name = "is_key")
    private Integer isKey;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return pdf_id
     */
    public Integer getPdfId() {
        return pdfId;
    }

    /**
     * @param pdfId
     */
    public void setPdfId(Integer pdfId) {
        this.pdfId = pdfId;
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
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return is_key
     */
    public Integer getIsKey() {
        return isKey;
    }

    /**
     * @param isKey
     */
    public void setIsKey(Integer isKey) {
        this.isKey = isKey;
    }
}