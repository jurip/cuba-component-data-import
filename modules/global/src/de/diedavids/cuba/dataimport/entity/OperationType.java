package de.diedavids.cuba.dataimport.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "DDCDI_OPERATION_TYPE")
@Entity(name = "ddcdi_OperationType")
public class OperationType extends StandardEntity {
    private static final long serialVersionUID = 1395577950013998112L;
}