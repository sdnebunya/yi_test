package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.ShohinBean;

public class ShohinService{

	private static final String POSTGRES_DRIVER = "org.postgresql.Driver";

    private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/lesson_db";

    private static final String USER = "postgres";

    private static final String PASS = "postgres";

    private static final String LIST_SELECT_SQL = "SELECT shohin_id,name,price,image_url FROM shohin_table where price <= ?;";

    private static final String DETAIL_SELECT_SQL = "SELECT * FROM shohin_table where shohin_id = ?;";

    private static final String BUY_UPDATE_SQL = "UPDATE shohin_table SET stock = ? WHERE shohin_id = ?;";

    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;

    ShohinBean shohinData;

	public ArrayList<ShohinBean> searchList(int money){
		ArrayList<ShohinBean> shohinList = new ArrayList<ShohinBean>();

		try {

			Class.forName(POSTGRES_DRIVER);
	        connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);

	        PreparedStatement psExecuteQuery = connection.prepareStatement(LIST_SELECT_SQL);
            psExecuteQuery.setInt(1, money);
            resultSet = psExecuteQuery.executeQuery();

            while (resultSet.next()) {
                String id = resultSet.getString("shohin_id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String imageUrl = resultSet.getString("image_url");

                shohinData = new ShohinBean();
                shohinData.setId(id);
                shohinData.setName(name);
                shohinData.setPrice(price);
                shohinData.setImageUrl(imageUrl);
                shohinList.add(shohinData);
            }


		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}

		return shohinList;
	}

	public ShohinBean showDetail(String id){

		try {

			Class.forName(POSTGRES_DRIVER);
	        connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);

	        PreparedStatement psExecuteQuery = connection.prepareStatement(DETAIL_SELECT_SQL);
            psExecuteQuery.setString(1, id);
            resultSet = psExecuteQuery.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int stock = resultSet.getInt("stock");
                String imageUrl = resultSet.getString("image_url");
                String lastDate = resultSet.getString("up_date");

                shohinData = new ShohinBean(id,name,price,stock,imageUrl,lastDate);
            }


		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}

		return shohinData;
	}

	public String shohinBuy(String id, int currentStock){
		String message = "";
		if(0 == currentStock) {
			message = "在庫がないため、購入できません";
			return message;
		}

		try {

			Class.forName(POSTGRES_DRIVER);
	        connection = DriverManager.getConnection(JDBC_CONNECTION, USER, PASS);

	        int updateStock = currentStock - 1;
	        PreparedStatement psExecuteUpdate = connection.prepareStatement(BUY_UPDATE_SQL);
	        psExecuteUpdate.setInt(1, updateStock);
            psExecuteUpdate.setString(2, id);
            psExecuteUpdate.executeUpdate();

            message = "購入しました。";


		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
		}

		return message;
	}
}