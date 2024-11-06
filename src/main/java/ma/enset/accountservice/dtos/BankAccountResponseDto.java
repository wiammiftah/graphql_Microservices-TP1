package ma.enset.accountservice.dtos;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.accountservice.enums.AccountType;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BankAccountResponseDto {
    private String id;
    private Date createdAt;
    private Double balance;
    private String currency;
    private AccountType accountType;
}
