package impl;

import jdbc.Item;
import jdbcDao.ItemDao;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoImpl implements ItemDao {
    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> list = new ArrayList<>();
        String sql = "select * from user";
        ResultSet result = null;
        Connection connection = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/maven","wind",
                    "cl100869011A");
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();
            list = new ArrayList<>();
            while (result.next()){
                //遍历resultSet,新建item类,查询数据库,将结果封装成item对象返回
                Item item = new Item();
                item.setId(result.getInt(1));
                item.setName(result.getString(2));
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            result.close();
            connection.close();
        }
        return list;
    }
    @Test
    public void demo() throws SQLException {
        List<Item> list = findAll();
        for (Item item : list) {
            System.out.println(item.getName());
        }
    }
}
