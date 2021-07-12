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
import java.sql.Types;

import fa.training.problem02.entities.Brand;
import fa.training.problem02.utils.DBUtils;
import fa.training.problem02.utils.SQLCommand;

public class BrandDAOImpl implements BrandDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private CallableStatement caStatement = null;

	@Override
	public boolean save(Brand brand) throws SQLException {
		boolean check = false;
		int results[] = null;
		try {
			connection = DBUtils.getInstance().getConnection();
			connection.setAutoCommit(false);
			preparedStatement = connection.prepareStatement(SQLCommand.BRAND_QUERY_SAVE);

			try {
				preparedStatement.setString(1, brand.getBrand_name());
				preparedStatement.setInt(2, brand.getStatus());
				preparedStatement.addBatch();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			results = preparedStatement.executeBatch();
			connection.commit();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
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

	@Override
	public boolean delete() throws SQLException {
		boolean check = false;
		try {
			connection = DBUtils.getInstance().getConnection();
			caStatement = connection.prepareCall(SQLCommand.BRAND_QUERY_DELETE);
			caStatement.registerOutParameter(1, Types.INTEGER);
			caStatement.execute();
			if(caStatement.getInt(1) > 0) {
				check = true;
			}
		}finally {
			try {
				if(connection != null) {
					connection.close();
				}
				if(caStatement != null) {
					caStatement.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

}
