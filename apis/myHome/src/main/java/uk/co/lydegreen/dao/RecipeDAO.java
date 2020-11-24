package uk.co.lydegreen.dao;

/**
 * Created by richard on 01/11/15.
 */


import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import uk.co.lydegreen.dao.mappers.RecipeMapper;
import uk.co.lydegreen.representations.Recipe;

public interface RecipeDAO {

    @Mapper(RecipeMapper.class)
    @SqlQuery("select * from Recipe where uid = :id")
    Recipe getRecipeById(@Bind("id") int id);

    @GetGeneratedKeys
    @SqlUpdate("insert into Recipe (id, uid, Description, created_on, updated, datetime) values (NULL, :uid, :name, :description)")
    int createRecipe(@Bind("uid") String uid, @Bind("name") String name, @Bind("description") String description);

    @SqlUpdate("insert into Recipe (id, uid, Description, created_on, updated datetime) values (NULL, :uid, :name, :description)")
    void updateRecipe(@Bind("uid") String uid, @Bind("name") String name, @Bind("description") String description);

    @SqlUpdate("delete from Recipe where uid = :id")
    void deleteRecipe(@Bind("id") int id);

}
