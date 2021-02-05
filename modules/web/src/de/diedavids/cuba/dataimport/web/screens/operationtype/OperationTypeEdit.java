package de.diedavids.cuba.dataimport.web.screens.operationtype;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.dataimport.entity.OperationType;

@UiController("ddcdi_OperationType.edit")
@UiDescriptor("operation-type-edit.xml")
@EditedEntityContainer("operationTypeDc")
@LoadDataBeforeShow
public class OperationTypeEdit extends StandardEditor<OperationType> {
}