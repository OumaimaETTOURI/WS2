package org.sid.bank_account_service.service;

import org.sid.bank_account_service.dtos.BankAccountRequestDTO;
import org.sid.bank_account_service.dtos.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.enums.AccountType;

public interface BankAccountService {
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
