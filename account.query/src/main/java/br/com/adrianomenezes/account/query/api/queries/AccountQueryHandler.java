package br.com.adrianomenezes.account.query.api.queries;

import br.com.adrianomenezes.account.query.api.dto.EqualityType;
import br.com.adrianomenezes.account.query.domain.AccountRepository;
import br.com.adrianomenezes.account.query.domain.BankAccount;
import br.com.adrianomenezes.cqrs.core.domain.BaseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountQueryHandler implements QueryHandler{
    
    @Autowired
    private AccountRepository accountRepository;
    
    @Override
    public List<BaseEntity> handle(FindAllAccountsQuery query) {
        Iterable<BankAccount> bankAccounts = accountRepository.findAll();
        List<BaseEntity> bankAccountsList = new ArrayList<>();
        bankAccounts.forEach(bankAccountsList::add);
        return bankAccountsList;
    }

    @Override
    public List<BaseEntity> handle(FindAccountsByIdQuery query) {
        var bankAccount= accountRepository.findById(query.getId());
        if (bankAccount.isEmpty()){
            return null;
        }
        List<BaseEntity> bankAccountsList = new ArrayList<>();
        bankAccountsList.add(bankAccount.get());
        return bankAccountsList;
    }

    @Override
    public List<BaseEntity> handle(FindAccountsByHolderQuery query) {
        List<BaseEntity> bankAccounts= accountRepository.findByAccountHolder(query.getAccountHolder());
        if (bankAccounts.isEmpty()){
            return null;
        }
        List<BaseEntity> bankAccountsList = new ArrayList<>();
        bankAccountsList.addAll(bankAccounts);
        return bankAccountsList;
    }

    @Override
    public List<BaseEntity> handle(FindAccountsWithBalanceQuery query) {

        List<BaseEntity> bankAccountsList = query.getEqualityType() == EqualityType.GREATER_THAN
                ?
                    accountRepository.findByBalanceGreaterThan(query.getBalance())
                :
                    accountRepository.findByBalanceLessThan(query.getBalance());

        return bankAccountsList;
    }
}
