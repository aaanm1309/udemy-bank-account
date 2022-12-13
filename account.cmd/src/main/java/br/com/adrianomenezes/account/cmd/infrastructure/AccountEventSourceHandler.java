package br.com.adrianomenezes.account.cmd.infrastructure;

import br.com.adrianomenezes.account.cmd.domain.AccountAggregate;
import br.com.adrianomenezes.cqrs.core.domain.AggregateRoot;
import br.com.adrianomenezes.cqrs.core.handlers.EventSourceHandler;
import br.com.adrianomenezes.cqrs.core.infrastructure.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class AccountEventSourceHandler implements EventSourceHandler {
    @Autowired
    private EventStore eventStore;

    @Override
    public void save(AggregateRoot aggregate) {
        eventStore.saveEvents(aggregate.getId(),aggregate.getUncommittedChanges(),aggregate.getVersion());
        aggregate.markChangesAsCommitted();

    }

    @Override
    public AccountAggregate getById(String id) {
        var aggregate =  new AccountAggregate();
        var events = eventStore.getEvents(id);
        if (events != null && !events.isEmpty()){
            aggregate.replayEvents(events);
            var latestVersion = events.stream()
                    .map(x -> x.getVersion()).max(Comparator.naturalOrder());

        }
        return  aggregate;
    }

}
