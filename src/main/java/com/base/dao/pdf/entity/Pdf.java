package com.base.dao.pdf.entity;

import javax.persistence.*;

public class Pdf {
    @Id
    private Integer id;

    @Column(name = "file_name")
    private String fileName;

    private String path;

    /**
     * ' '
     */
    @Column(name = "set_name")
    private String setName;

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
     * @return file_name
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取' '
     *
     * @return set_name - ' '
     */
    public String getSetName() {
        return setName;
    }

    /**
     * 设置' '
     *
     * @param setName ' '
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }
}