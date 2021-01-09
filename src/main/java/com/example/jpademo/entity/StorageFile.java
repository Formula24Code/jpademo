package com.example.jpademo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "storage_file")
public class StorageFile {
    private String fileId;
    private String fileName;
    private Integer fileStatus;
    private Date fileUpdateTime;
    private String dirId;
    private String pathId;
    private StorageDir storageDir; //关联表的实体类
    private StoragePath storagePath; //关联表的实体类

    @ManyToOne // 定义表之间的记录关系，这里为多对一
    // 定义关联字段，name为数据库里的字段名称
    // insertable和updatable设成false防止重复映射问题
    @JoinColumn(name = "dir_id", insertable = false, updatable = false)
    public StorageDir getStorageDir() {
        return storageDir;
    }

    public void setStorageDir(StorageDir storageDir) {
        this.storageDir = storageDir;
    }

    @ManyToOne
    @JoinColumn(name = "path_id", insertable = false, updatable = false)
    public StoragePath getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(StoragePath storagePath) {
        this.storagePath = storagePath;
    }

    @Id
    @Column(name = "file_id")
    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    @Basic
    @Column(name = "file_name")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Basic
    @Column(name = "file_status")
    public Integer getFileStatus() {
        return fileStatus;
    }

    public void setFileStatus(Integer fileStatus) {
        this.fileStatus = fileStatus;
    }

    @Basic
    @Column(name = "file_update_time")
    public Date getFileUpdateTime() {
        return fileUpdateTime;
    }

    public void setFileUpdateTime(Date fileUpdateTime) {
        this.fileUpdateTime = fileUpdateTime;
    }

    @Basic
    @Column(name = "dir_id")
    public String getDirId() {
        return dirId;
    }

    public void setDirId(String dirId) {
        this.dirId = dirId;
    }

    @Basic
    @Column(name = "path_id")
    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageFile that = (StorageFile) o;
        return Objects.equals(fileId, that.fileId) && Objects.equals(fileName, that.fileName) && Objects.equals(fileStatus, that.fileStatus) && Objects.equals(fileUpdateTime, that.fileUpdateTime) && Objects.equals(dirId, that.dirId) && Objects.equals(pathId, that.pathId) && Objects.equals(storageDir, that.storageDir) && Objects.equals(storagePath, that.storagePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileId, fileName, fileStatus, fileUpdateTime, dirId, pathId, storageDir, storagePath);
    }
}
