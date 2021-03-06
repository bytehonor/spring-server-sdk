package com.bytehonor.sdk.server.bytehonor.jdbc.update;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bytehonor.sdk.server.bytehonor.query.MatchColumn;

public class UpdatePreparedStatementTest {

    private static final Logger LOG = LoggerFactory.getLogger(UpdatePreparedStatementTest.class);

    @Test
    public void test() {
        String sc = null;
        UpdatePreparedStatement statement = UpdatePreparedStatement.create("tbl_user");
        statement.set("name", "john");
        statement.set("age", 13);
        statement.set("school", sc);
        statement.set("create_at", System.currentTimeMillis());
        statement.match(MatchColumn.eq("id", 3333));

        LOG.info("sql:{}", statement.toUpdateSql());
        List<Object> args = statement.listArgs();
        LOG.info("args:{}", args);
        assertTrue(args.size() == 4, "test");
    }

}
