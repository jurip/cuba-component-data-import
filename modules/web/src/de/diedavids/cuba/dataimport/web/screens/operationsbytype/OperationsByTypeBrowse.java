package de.diedavids.cuba.dataimport.web.screens.operationsbytype;

import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.dataimport.entity.OperationsByType;
import de.diedavids.cuba.dataimport.web.screens.operation.OperationBrowse;

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


    @Inject
    private GroupTable<OperationsByType> operationsByTypesTable;
    @Inject
    private Screens screens;

    @Subscribe
    protected void onInit(InitEvent event) {
        operationsByTypesTable.setItemClickAction(new BaseAction("itemClickAction")
                .withHandler(actionPerformedEvent -> {
                    OperationsByType customer = operationsByTypesTable.getSingleSelected();
                    if (customer != null) {
                        OperationBrowse screen = screens.create(OperationBrowse.class);
                        screen.setAccountNumber(customer.getAccountNumber());
                        screens.show(screen);

                    }
                }));

    }
}