package ma.enset.accountservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.accountservice.enums.AccountType;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BankAccountRequestDto {
    Double initialBAlance;
    AccountType accountType;
}
