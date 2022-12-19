package br.com.adrianomenezes.account.query.api.queries;

import br.com.adrianomenezes.cqrs.core.queries.BaseQuery;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FindAccountsByHolderQuery extends BaseQuery {
    private String accountHolder;
}
