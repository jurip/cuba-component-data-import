package de.diedavids.cuba.dataimport.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "DDCDI_OPERATION")
@Entity(name = "ddcdi_Operation")
public class Operation extends StandardEntity {
    private static final long serialVersionUID = 6497785863344811442L;
}