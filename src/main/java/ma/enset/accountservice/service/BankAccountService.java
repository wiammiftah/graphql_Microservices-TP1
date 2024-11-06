package ma.enset.accountservice.service;

import ma.enset.accountservice.dtos.BankAccountRequestDto;
import ma.enset.accountservice.dtos.BankAccountResponseDto;
import ma.enset.accountservice.entities.BankAccount;
import ma.enset.accountservice.enums.AccountType;

public interface BankAccountService {
    BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountRequestDto);
}