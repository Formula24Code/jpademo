package com.example.jpademo.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "storage_path")
public class StoragePath {
    private String pathId;
    private Integer pathNode;
    private String pathValue;

    @Id
    @Column(name = "path_id")
    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    @Basic
    @Column(name = "path_node")
    public Integer getPathNode() {
        return pathNode;
    }

    public void setPathNode(Integer pathNode) {
        this.pathNode = pathNode;
    }

    @Basic
    @Column(name = "path_value")
    public String getPathValue() {
        return pathValue;
    }

    public void setPathValue(String pathValue) {
        this.pathValue = pathValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoragePath that = (StoragePath) o;
        return Objects.equals(pathId, that.pathId) && Objects.equals(pathNode, that.pathNode) && Objects.equals(pathValue, that.pathValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pathId, pathNode, pathValue);
    }
}
