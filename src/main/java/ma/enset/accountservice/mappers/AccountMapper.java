package ma.enset.accountservice.mappers;

import ma.enset.accountservice.dtos.BankAccountResponseDto;
import ma.enset.accountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AccountMapper {
    public BankAccountResponseDto fromAccount(BankAccount account){
        BankAccountResponseDto bankAccountResponseDto=new BankAccountResponseDto();
        BeanUtils.copyProperties(account, bankAccountResponseDto);
        return bankAccountResponseDto;
    }
}
