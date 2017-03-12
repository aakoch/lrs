package com.adamkoch.lrs;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Created by aakoch on 2017-03-11
 */
public class StatementBuilderTest {

    StatementBuilder builder = new StatementBuilder();

    @Test
    public void build() throws Exception {
        assertThat(builder.build(), instanceOf(Statement.class));
    }

    @Test
    public void id() throws Exception {
        StatementId testStatementId = new StatementId(UUID.randomUUID());
        assertThat(builder.id(testStatementId).build().getStatementId(), equalTo(testStatementId));
    }

    @Test
    public void timestamp() throws Exception {
        LocalDateTime testTimestamp = LocalDateTime.now();
        assertThat(builder.timestamp(testTimestamp).build().getTimestamp(), equalTo(testTimestamp));
    }

    @Test
    public void actor() throws Exception {
        Actor testActor = new Actor();
        assertThat(builder.actor(testActor).build().getActor(), equalTo(testActor));
    }

}