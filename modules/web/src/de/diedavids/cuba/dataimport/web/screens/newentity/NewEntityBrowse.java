package de.diedavids.cuba.dataimport.web.screens.newentity;

import com.haulmont.cuba.core.global.MetadataTools;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.dataimport.entity.NewEntity;
import de.diedavids.cuba.dataimport.entity.Operation;
import de.diedavids.cuba.dataimport.entity.OperationsByType;
import de.diedavids.cuba.dataimport.web.screens.operation.AccountOperationBrowse;
import de.diedavids.cuba.dataimport.web.screens.operation.OperationBrowse;
import de.diedavids.cuba.dataimport.web.screens.operationsbytype.OperationsByTypeBrowse;

import javax.inject.Inject;

@UiController("ddcdi_NewEntity.browse")
@UiDescriptor("new-entity-browse.xml")
@LookupComponent("newEntitiesTable")
@LoadDataBeforeShow
public class NewEntityBrowse extends StandardLookup<NewEntity> {
    @Inject
    private Table<NewEntity> newEntitiesTable;

    @Inject
    private Screens screens;

    @Subscribe
    protected void onInit(InitEvent event) {
        newEntitiesTable.setItemClickAction(new BaseAction("itemClickAction")
                .withHandler(actionPerformedEvent -> {
                    NewEntity customer = newEntitiesTable.getSingleSelected();
                    if (customer != null) {

                        OperationsByTypeBrowse screen = screens.create(OperationsByTypeBrowse.class);
                        screen.setAccountNumber(customer.getAccountNumber());
                        screens.show(screen);

                    }
                }));

    }
}