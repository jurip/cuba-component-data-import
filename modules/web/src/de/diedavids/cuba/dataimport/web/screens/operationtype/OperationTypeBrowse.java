package de.diedavids.cuba.dataimport.web.screens.operationtype;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.dataimport.entity.OperationType;

@UiController("ddcdi_OperationType.browse")
@UiDescriptor("operation-type-browse.xml")
@LookupComponent("operationTypesTable")
@LoadDataBeforeShow
public class OperationTypeBrowse extends StandardLookup<OperationType> {
}