/*
 * Copyright 2019 Fresher Academy
 * @author AnTV5
 * @date Nov 19, 2019
 * @version 1.0
*/
package fa.training.problem02.dao;

import java.sql.SQLException;
import java.util.List;

import fa.training.problem02.entities.Product;

public interface ProductDAO {
	boolean update(Product product) throws SQLException;
	boolean addProducts(final List<Product> product, int brand_id) throws SQLException;
}
