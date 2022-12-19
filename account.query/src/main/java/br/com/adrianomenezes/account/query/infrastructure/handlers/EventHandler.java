package br.com.adrianomenezes.account.query.infrastructure.handlers;

import br.com.adrianomenezes.account.common.events.AccountClosedEvent;
import br.com.adrianomenezes.account.common.events.AccountOpenedEvent;
import br.com.adrianomenezes.account.common.events.FundsDepositedEvent;
import br.com.adrianomenezes.account.common.events.FundsWithdrawnEvent;

public interface EventHandler {
    void on(AccountOpenedEvent event);
    void on(FundsDepositedEvent event);
    void on(FundsWithdrawnEvent event);
    void on(AccountClosedEvent event);
}
