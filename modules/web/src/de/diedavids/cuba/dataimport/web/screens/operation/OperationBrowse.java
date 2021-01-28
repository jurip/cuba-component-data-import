package de.diedavids.cuba.dataimport.web.screens.operation;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.dataimport.entity.Operation;

import javax.inject.Inject;

@UiController("ddcdi_Operation.browse")
@UiDescriptor("operation-browse.xml")
@LookupComponent("operationsTable")
@LoadDataBeforeShow
public class OperationBrowse extends StandardLookup<Operation> {
    private String accountNumber;
    @Inject
    private CollectionLoader<Operation> operationsDl;

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        if(accountNumber!=null) {
            operationsDl.setParameter("accountNumber", accountNumber);
            operationsDl.load();
        }
    }
}