/*
 * Copyright 2019 Fresher Academy
 * @author AnTV5
 * @date Nov 19, 2019
 * @version 1.0
*/
package fa.training.problem02.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import fa.training.problem02.entities.Product;
import fa.training.problem02.utils.DBUtils;
import fa.training.problem02.utils.SQLCommand;

public class ProductDAOImpl implements ProductDAO{
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private CallableStatement caStatement = null;
	
	@Override
	public boolean update(Product product) throws SQLException {
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(SQLCommand.PRODUCT_QUERY_UPDATE);
			//UPDATE dbo.Product SET product_name=?, model_year=?, list_price=? WHERE product_id=?
			preparedStatement.setString(1, product.getProduct_name());
			preparedStatement.setString(2, product.getModel_year());
			preparedStatement.setDouble(3, product.getList_price());
			preparedStatement.setInt(4, product.getProduct_id());
			int result = preparedStatement.executeUpdate();
			if(result > 0) {
				check = true;
			}
			
		} finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}


	@Override
	public boolean addProducts(List<Product> product, int brand_id) throws SQLException {
		boolean check = false;
        int results[] = null;
        try {
            connection = DBUtils.getInstance().getConnection();
            connection.setAutoCommit(false);
            caStatement = 
				connection.prepareCall(SQLCommand.PRODUCT_QUERY_ADD);

            product.stream().forEach((prod) -> {
                try {
                	//@product_name VARCHAR(100), @year VARCHAR(100)
                	//@price MONEY, @brand_id INT
                	caStatement.setString(1, prod.getProduct_name());
                	caStatement.setString(2, prod.getModel_year());
                	caStatement.setDouble(3, prod.getList_price());
                	caStatement.setInt(4, brand_id);
                	caStatement.addBatch();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            results = caStatement.executeBatch();
            connection.commit();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (caStatement != null) {
                	caStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (results.length > 0) {
            check = true;
        }
        return check;
	}

}
