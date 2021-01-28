package de.diedavids.cuba.dataimport.web.screens.account;

import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import de.diedavids.cuba.dataimport.entity.Account;
import de.diedavids.cuba.dataimport.entity.Operation;

import javax.inject.Inject;

@UiController("ddcdi_Account.edit")
@UiDescriptor("account-edit.xml")
@EditedEntityContainer("accountDc")
@LoadDataBeforeShow
public class AccountEdit extends StandardEditor<Account> {

}