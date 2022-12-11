package br.com.adrianomenezes.account.cmd.api.commands;

import br.com.adrianomenezes.cqrs.core.commands.BaseCommand;
import lombok.Data;

@Data
public class DepositFundsCommand extends BaseCommand {
    private double amount;
}
