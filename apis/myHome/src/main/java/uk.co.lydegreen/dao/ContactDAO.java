package uk.co.lydegreen.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import uk.co.lydegreen.representations.Contact;
import uk.co.lydegreen.dao.mappers.ContactMapper;
/**
 * Created by richard on 06/03/17.
 */
public interface ContactDAO {
    @Mapper(ContactMapper.class)
    @SqlQuery("select * from contact where id = :id")
    Contact getContactById(@Bind("id") int id);

    @GetGeneratedKeys
    @SqlUpdate("insert into contact (id, firstName, lastName, phone) values (NULL, :firstName, :lastName, :phone)")
    int createContact(@Bind("firstName") String firstName, @Bind("lastName") String lastName, @Bind("phone") String phone);

    @SqlUpdate("update contact set firstName = :firstName, lastName = :lastName, phone = :phone where id = :id")
    void updateContact(@Bind("id") int id, @Bind("firstName") String firstName, @Bind("lastName") String lastName, @Bind("phone") String phone);

    @SqlUpdate("delete from contact where id = :id")
    void deleteContact(@Bind("id") int id);
}
