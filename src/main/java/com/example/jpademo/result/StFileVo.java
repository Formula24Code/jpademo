package com.example.jpademo.result;

import java.util.Date;

public class StFileVo {
    private String fileName;
    private Date fileUpdateTime;
    private String dirName;
    private Integer dirDeep;
    private Integer pathNode;
    private String pathValue;

    // 需要什么字段，就定义什么样的构造函数
    public StFileVo(String fileName, Date fileUpdateTime, String dirName, Integer dirDeep, Integer pathNode, String pathValue) {
        this.fileName = fileName;
        this.fileUpdateTime = fileUpdateTime;
        this.dirName = dirName;
        this.dirDeep = dirDeep;
        this.pathNode = pathNode;
        this.pathValue = pathValue;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getFileUpdateTime() {
        return fileUpdateTime;
    }

    public void setFileUpdateTime(Date fileUpdateTime) {
        this.fileUpdateTime = fileUpdateTime;
    }

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public Integer getDirDeep() {
        return dirDeep;
    }

    public void setDirDeep(Integer dirDeep) {
        this.dirDeep = dirDeep;
    }

    public Integer getPathNode() {
        return pathNode;
    }

    public void setPathNode(Integer pathNode) {
        this.pathNode = pathNode;
    }

    public String getPathValue() {
        return pathValue;
    }

    public void setPathValue(String pathValue) {
        this.pathValue = pathValue;
    }
}
