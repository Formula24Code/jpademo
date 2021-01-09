package com.example.jpademo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "storage_dir")
public class StorageDir {
    private String dirId;
    private String dirName;
    private Integer dirDeep;
    private String parentDirId;
    private Date dirUpdateTime;

    @Id
    @Column(name = "dir_id")
    public String getDirId() {
        return dirId;
    }

    public void setDirId(String dirId) {
        this.dirId = dirId;
    }

    @Basic
    @Column(name = "dir_name")
    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    @Basic
    @Column(name = "dir_deep")
    public Integer getDirDeep() {
        return dirDeep;
    }

    public void setDirDeep(Integer dirDeep) {
        this.dirDeep = dirDeep;
    }

    @Basic
    @Column(name = "parent_dir_id")
    public String getParentDirId() {
        return parentDirId;
    }

    public void setParentDirId(String parentDirId) {
        this.parentDirId = parentDirId;
    }

    @Basic
    @Column(name = "dir_update_time")
    public Date getDirUpdateTime() {
        return dirUpdateTime;
    }

    public void setDirUpdateTime(Date dirUpdateTime) {
        this.dirUpdateTime = dirUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageDir that = (StorageDir) o;
        return Objects.equals(dirId, that.dirId) && Objects.equals(dirName, that.dirName) && Objects.equals(dirDeep, that.dirDeep) && Objects.equals(parentDirId, that.parentDirId) && Objects.equals(dirUpdateTime, that.dirUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dirId, dirName, dirDeep, parentDirId, dirUpdateTime);
    }
}
