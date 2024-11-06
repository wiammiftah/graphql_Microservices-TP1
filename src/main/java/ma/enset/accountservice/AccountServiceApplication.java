package ma.enset.accountservice;

import ma.enset.accountservice.entities.BankAccount;
import ma.enset.accountservice.enums.AccountType;
import ma.enset.accountservice.repositories.BankAccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepo bankAccountRepo){
        return args -> {

            for (int i = 0; i < 10; i++) {
                BankAccount bankAccount = BankAccount.builder()
                        .id(UUID.randomUUID().toString())
                        .accountType(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVINGS_ACCOUNT)
                        .balance(Math.random()*10000)
                        .createdAt(new Date())
                        .currency("USD")
                        .build();
                bankAccountRepo.save(bankAccount);
            }

        };
    }
}
