package de.diedavids.cuba.dataimport.entity;

import com.haulmont.cuba.core.entity.StandardEntity;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "DDCDI_COUNTER_AGENT")
@Entity(name = "ddcdi_CounterAgent")
public class CounterAgent extends StandardEntity {
    private static final long serialVersionUID = 2948263183166837290L;
}