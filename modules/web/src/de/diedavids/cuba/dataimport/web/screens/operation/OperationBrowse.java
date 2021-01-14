package de.diedavids.cuba.dataimport.web.screens.operation;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.dataimport.entity.Operation;

@UiController("ddcdi_Operation.browse")
@UiDescriptor("operation-browse.xml")
@LookupComponent("operationsTable")
@LoadDataBeforeShow
public class OperationBrowse extends StandardLookup<Operation> {
}