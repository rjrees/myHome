package uk.co.lydegreen.dao;

/**
 * Created by richard on 01/11/15.
 */


import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import uk.co.lydegreen.dao.mappers.statementMapper;
import uk.co.lydegreen.representations.Statement;

public interface statementDAO {

    @Mapper(statementMapper.class)
    @SqlQuery("select * from AccountStatement where ID = :id")
    Statement getStatementByDateRange(@Bind("id") int id);
/**
    @Mapper(statementMapper.class)
    @SqlQuery("select * from AccountStatement where id = :id")
    Statement getRecipeById(@Bind("id") int id);

    @GetGeneratedKeys
    @SqlUpdate("insert into RecipeIngredients (id, UID, lastName, phone) values (NULL, :firstName, :lastName, :phone)")
    int createRecipeIngredients(@Bind("firstName") String firstName, @Bind("lastName") String lastName, @Bind("phone") String phone);
 **/
    @SqlUpdate("update Recipe set firstName = :firstName, lastName = :lastName, phone = :phone where id = :id")
    void updateRecipe(@Bind("id") int id, @Bind("firstName") String firstName, @Bind("lastName") String lastName, @Bind("phone") String phone);

    @SqlUpdate("delete from Recipe where id = :id")
    void deleteRecipe(@Bind("id") int id);

}
