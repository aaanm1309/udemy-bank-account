package br.com.adrianomenezes.account.query.api.queries;

import br.com.adrianomenezes.account.query.api.dto.EqualityType;
import br.com.adrianomenezes.cqrs.core.queries.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindAccountsWithBalanceQuery extends BaseQuery {
    private EqualityType equalityType;
    private double balance;
}
