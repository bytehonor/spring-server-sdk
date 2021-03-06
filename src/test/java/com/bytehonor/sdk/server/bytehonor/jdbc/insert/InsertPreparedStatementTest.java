package com.bytehonor.sdk.server.bytehonor.jdbc.insert;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertPreparedStatementTest {

    private static final Logger LOG = LoggerFactory.getLogger(InsertPreparedStatementTest.class);

    @Test
    public void test() {
        InsertPreparedStatement statement = InsertPreparedStatement.create("tbl_user", "name,age,school,true_false,time");
        for (int i = 0; i < 3; i++) {
            statement.rowBegin();
            statement.setColumn("name" + i);
            statement.setColumn(i);
            statement.setColumn("school';drop table tbl_other;--");
            statement.setColumn(true);
            statement.setColumn(System.currentTimeMillis());
            statement.rowEnd();
        }

        LOG.info("sql:{}", statement.toInsertSql());
        LOG.info("rowsSize:{}", statement.getRowSize());
        assertTrue(statement.getRowSize() == 3, "test");
    }

}
