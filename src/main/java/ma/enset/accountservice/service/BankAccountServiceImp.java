package ma.enset.accountservice.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.enset.accountservice.dtos.BankAccountRequestDto;
import ma.enset.accountservice.dtos.BankAccountResponseDto;
import ma.enset.accountservice.entities.BankAccount;
import ma.enset.accountservice.mappers.AccountMapper;
import ma.enset.accountservice.repositories.BankAccountRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class BankAccountServiceImp implements BankAccountService{
    private BankAccountRepo repo;
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDto addAccount(BankAccountRequestDto bankAccountRequestDto) {
        BankAccount bankAccount = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .currency("MAD")
                .accountType(bankAccountRequestDto.getAccountType())
                .balance(bankAccountRequestDto.getInitialBAlance())
                .build();
        BankAccount savedBankAccount = repo.save(bankAccount);
        BankAccountResponseDto responseDto = accountMapper.fromAccount(savedBankAccount);
        return responseDto;
    }
}
