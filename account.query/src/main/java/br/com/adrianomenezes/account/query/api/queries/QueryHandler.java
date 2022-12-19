package br.com.adrianomenezes.account.query.api.queries;

import br.com.adrianomenezes.cqrs.core.domain.BaseEntity;

import java.util.List;

public interface QueryHandler {
    List<BaseEntity> handle(FindAllAccountsQuery query);
    List<BaseEntity> handle(FindAccountsByIdQuery query);
    List<BaseEntity> handle(FindAccountsByHolderQuery query);
    List<BaseEntity> handle(FindAccountsWithBalanceQuery query);
}
