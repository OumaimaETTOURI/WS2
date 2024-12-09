package org.sid.bank_account_service.entities;

import org.sid.bank_account_service.enums.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types=BankAccount.class,name = "p1")// que pour select
public interface AccountProjection {
    public String getId();
    public AccountType getType();
    public Double getBalance();

}
