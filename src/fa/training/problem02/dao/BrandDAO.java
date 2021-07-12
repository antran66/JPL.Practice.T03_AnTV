/*
 * Copyright 2019 Fresher Academy
 * @author AnTV5
 * @date Nov 19, 2019
 * @version 1.0
*/
package fa.training.problem02.dao;

import java.sql.SQLException;

import fa.training.problem02.entities.Brand;

public interface BrandDAO {
	boolean save(Brand brand) throws SQLException;
	boolean delete() throws SQLException;
}
