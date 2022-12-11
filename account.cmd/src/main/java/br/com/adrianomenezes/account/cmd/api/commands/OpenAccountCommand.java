package br.com.adrianomenezes.account.cmd.api.commands;

import br.com.adrianomenezes.account.common.dto.AccountType;
import br.com.adrianomenezes.cqrs.core.commands.BaseCommand;
import lombok.Data;

@Data
public class OpenAccountCommand extends BaseCommand {
    private String accountHolder;
    private AccountType accountType;
    private double openingBalance;
}
