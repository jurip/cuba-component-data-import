package de.diedavids.cuba.dataimport.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "DDCDI_OPERATION_TYPE")
@Entity(name = "ddcdi_OperationType")
@NamePattern("%s|name")
public class OperationType extends StandardEntity {
    private static final long serialVersionUID = 1395577950013998112L;

    @Override
    public String toString() {
        return name;
    }

    @Column(name = "NAME")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}