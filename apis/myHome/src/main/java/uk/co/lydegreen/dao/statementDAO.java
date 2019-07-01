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
    @SqlQuery("select * from AccountStatement where ID = id")
    Statement getStatementByDateRange(@Bind("id") int id);

}
