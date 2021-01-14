package de.diedavids.cuba.dataimport.web.screens.operation;

import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.dataimport.entity.Operation;

@UiController("ddcdi_Operation.edit")
@UiDescriptor("operation-edit.xml")
@EditedEntityContainer("operationDc")
@LoadDataBeforeShow
public class OperationEdit extends StandardEditor<Operation> {
}