package br.com.adrianomenezes.account.cmd.api.commands;

import br.com.adrianomenezes.cqrs.core.commands.BaseCommand;
import lombok.Data;

@Data
public class CloseAccountCommand extends BaseCommand {
    public CloseAccountCommand(String id){
        super(id);
    }

}
