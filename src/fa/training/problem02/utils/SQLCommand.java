/*
 * Copyright 2019 Fresher Academy
 * @author AnTV5
 * @date Nov 19, 2019
 * @version 1.0
*/
package fa.training.problem02.utils;

public class SQLCommand {
	public static String BRAND_QUERY_SAVE = "INSERT INTO dbo.Brand(brand_name, [status]) VALUES(?, ?)";
	public static String BRAND_QUERY_DELETE = "{CALL usp_DeleteBrandIsInactive(?)}";
	public static String PRODUCT_QUERY_UPDATE= "UPDATE dbo.Product SET product_name=?, model_year=?, list_price=? WHERE product_id=?";
	public static String PRODUCT_QUERY_ADD = "{CALL usp_AddProduct(?, ?, ?, ?)}";
}
