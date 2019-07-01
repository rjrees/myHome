package uk.co.lydegreen.dao.mappers;

/**
 * Created by richard on 01/11/15.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import uk.co.lydegreen.representations.Statement;

public class statementMapper implements ResultSetMapper<Statement>{

    public Statement map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        return new Statement(
                r.getInt("id"), r.getString("UID"),
                r.getBoolean("Public"),r.getDate("TransactionDate"), r.getString("Type"), r.getString("SortCode"),
                r.getInt("AccountNumber"), r.getString("Description"), r.getInt("Credit"), r.getInt("Debit"), r.getInt("Ballance"), r.getInt("ACL"));
    }
}
