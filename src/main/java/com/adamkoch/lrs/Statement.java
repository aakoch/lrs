package com.adamkoch.lrs;

import java.time.LocalDateTime;

/**
 * Created by aakoch on 2017-03-11
 */
public class Statement {
    private StatementId statementId;
    private LocalDateTime timestamp;
    private Actor actor;

    public void setStatementId(StatementId statementId) {
        this.statementId = statementId;
    }

    public StatementId getStatementId() {
        return statementId;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Actor getActor() {
        return actor;
    }
}
