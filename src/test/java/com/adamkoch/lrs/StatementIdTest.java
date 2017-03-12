package com.adamkoch.lrs;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.*;

/**
 * Created by aakoch on 2017-03-11
 *
 */
public class StatementIdTest {

    @Test(expected = IllegalArgumentException.class)
    public void testOf_withInvalidStatementId_throwsIllegalArgumentException() throws Exception {
        StatementId.of("a");
    }

    @Test
    public void testOf_withValidStatementId() throws Exception {
        String uuidAsString = "fd41c918-b88b-4b20-a0a5-a4c32391aaa0";
        StatementId statementId = StatementId.of(uuidAsString);
        assertThat(statementId, instanceOf(StatementId.class));
        assertThat(statementId.toString(), equalTo(uuidAsString));
    }

}