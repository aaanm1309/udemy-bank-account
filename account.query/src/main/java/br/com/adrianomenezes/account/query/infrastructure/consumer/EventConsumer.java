package br.com.adrianomenezes.account.query.infrastructure.consumer;

import br.com.adrianomenezes.account.common.events.AccountClosedEvent;
import br.com.adrianomenezes.account.common.events.AccountOpenedEvent;
import br.com.adrianomenezes.account.common.events.FundsDepositedEvent;
import br.com.adrianomenezes.account.common.events.FundsWithdrawnEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {
    void consume(@Payload AccountOpenedEvent event, Acknowledgment ack);
    void consume(@Payload FundsDepositedEvent event, Acknowledgment ack);
    void consume(@Payload FundsWithdrawnEvent event, Acknowledgment ack);
    void consume(@Payload AccountClosedEvent event, Acknowledgment ack);

}
