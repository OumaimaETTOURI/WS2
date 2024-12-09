package org.sid.bank_account_service.service;

import org.sid.bank_account_service.dtos.BankAccountRequestDTO;
import org.sid.bank_account_service.dtos.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.mappers.AccountMapper;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Autowired

    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount= BankAccount.builder()
                //mapping
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        //ce code ne faut pas etre la
//        BankAccountResponseDTO bankAccountResponseDTO=BankAccountResponseDTO.builder()
//                .id(savedBankAccount.getId())
//                .type(savedBankAccount.getType())
//                .createdAt(savedBankAccount.getCreatedAt())
//                .balance(savedBankAccount.getBalance())
//                .currency(savedBankAccount.getCurrency())
//                .build();
        BankAccount savedBankAccount=bankAccountRepository.save(bankAccount);//code metier
        BankAccountResponseDTO bankAccountResponseDTO=accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount= BankAccount.builder()
                //mapping
                .id(id)
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        //ce code ne faut pas etre la
//        BankAccountResponseDTO bankAccountResponseDTO=BankAccountResponseDTO.builder()
//                .id(savedBankAccount.getId())
//                .type(savedBankAccount.getType())
//                .createdAt(savedBankAccount.getCreatedAt())
//                .balance(savedBankAccount.getBalance())
//                .currency(savedBankAccount.getCurrency())
//                .build();
        BankAccount savedBankAccount=bankAccountRepository.save(bankAccount);//code metier
        BankAccountResponseDTO bankAccountResponseDTO=accountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
}
