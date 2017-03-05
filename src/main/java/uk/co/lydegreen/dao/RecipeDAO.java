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
    @SqlQuery("select * from Recipe where UID = :id")
    Recipe getRecipeById(@Bind("id") int id);

    @GetGeneratedKeys
    @SqlUpdate("insert into Recipe (id, UID, Description, created_on, updated datetime) values (NULL, :UID, :name, :description)")
    int createRecipe(@Bind("UID") String UID, @Bind("name") String name, @Bind("description") String description);

    @SqlUpdate("insert into Recipe (id, UID, Description, created_on, updated datetime) values (NULL, :UID, :name, :description)")
    void updateRecipe(@Bind("UID") String UID, @Bind("name") String name, @Bind("description") String description);

    @SqlUpdate("delete from Recipe where UID = :id")
    void deleteRecipe(@Bind("id") int id);

}
