package jdbcDao;

import jdbc.Item;

import java.sql.SQLException;
import java.util.List;

public interface ItemDao {
    public List<Item> findAll() throws SQLException;
}
