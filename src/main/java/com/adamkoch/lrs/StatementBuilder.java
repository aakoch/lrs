package com.adamkoch.lrs;

import java.time.LocalDateTime;

/**
 * Created by aakoch on 2017-03-11
 */
public class StatementBuilder {

    private StatementId statementId;
    private LocalDateTime localDateTime;
    private Actor actor;

    public Statement build() {
        Statement statement = new Statement();
        statement.setStatementId(statementId);
        statement.setTimestamp(localDateTime);
        statement.setActor(actor);
        return statement;
    }

    public StatementBuilder id(StatementId statementId) {
        this.statementId = statementId;
        return this;
    }

    public StatementBuilder timestamp(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;

        return this;
    }

    public StatementBuilder actor(Actor actor) {
        this.actor = actor;
        return this;
    }
}
