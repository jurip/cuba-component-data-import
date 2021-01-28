package de.diedavids.cuba.dataimport.web.screens.operationsbytype;

import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.dataimport.entity.Operation;
import de.diedavids.cuba.dataimport.entity.OperationsByType;

import javax.inject.Inject;

@UiController("ddcdi_OperationsByType.browse")
@UiDescriptor("operations-by-type-browse.xml")
@LookupComponent("operationsByTypesTable")
public class OperationsByTypeBrowse extends StandardLookup<OperationsByType> {
    private String accountNumber;
    @Inject
    private CollectionLoader<OperationsByType> operationsByTypesDl;

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        if(accountNumber!=null) {
            operationsByTypesDl.setParameter("accountNumber", accountNumber);
            operationsByTypesDl.load();
        }
    }
}