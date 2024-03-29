package chess.model;

import chess.constants.AccountStatus;

import java.util.UUID;

/*Chess*/
public abstract class Account {
    private final String accountId;
    private final String name;
    private final String email;
    private final AccountStatus accountStatus;

    public Account(String name, String email) {
        this.accountId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.accountStatus = AccountStatus.ACTIVE;
    }
}
