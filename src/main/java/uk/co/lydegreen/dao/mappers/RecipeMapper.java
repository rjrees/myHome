package uk.co.lydegreen.dao.mappers;

/**
 * Created by richard on 01/11/15.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import uk.co.lydegreen.representations.Recipe;

public class RecipeMapper implements ResultSetMapper<Recipe>{

    public Recipe map(int index, ResultSet r, StatementContext ctx)
            throws SQLException {
        return new Contact(
                r.getInt("id"), r.getString("firstName"),
                r.getString("lastName"),r.getString("phone"));
    }
}
