package ma.enset.accountservice.web;

import ma.enset.accountservice.dtos.BankAccountRequestDto;
import ma.enset.accountservice.dtos.BankAccountResponseDto;
import ma.enset.accountservice.entities.BankAccount;
import ma.enset.accountservice.repositories.BankAccountRepo;
import ma.enset.accountservice.service.BankAccountServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphqlController {
    @Autowired
    private BankAccountRepo bankAccountRepo;
    @Autowired
    private BankAccountServiceImp bankAccountServiceImp;

    @QueryMapping
    public List<BankAccount> accountList(){
        return bankAccountRepo.findAll();
    }
    @QueryMapping
    public BankAccount accountById(@Argument String id){
        return bankAccountRepo.findById(id).orElseThrow(
                ()->new RuntimeException("Bank account not found")
        );
    }
    @MutationMapping
    public BankAccountResponseDto addAccount(@Argument BankAccountRequestDto bankAccount){
        return bankAccountServiceImp.addAccount(bankAccount);
    }

}
