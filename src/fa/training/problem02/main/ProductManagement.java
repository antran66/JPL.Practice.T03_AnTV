/*
 * Copyright 2019 Fresher Academy
 * @author AnTV5
 * @date Nov 19, 2019
 * @version 1.0
*/
package fa.training.problem02.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fa.training.problem02.dao.BrandDAO;
import fa.training.problem02.dao.BrandDAOImpl;
import fa.training.problem02.dao.ProductDAO;
import fa.training.problem02.dao.ProductDAOImpl;
import fa.training.problem02.entities.Brand;
import fa.training.problem02.entities.Product;

public class ProductManagement {
	static BrandDAO brandDAO = new BrandDAOImpl();
	static ProductDAO productDAO = new ProductDAOImpl();
	private static Scanner scanner;

	public static void main(String[] args) throws SQLException {
		scanner = new Scanner(System.in);
		List<Product> products = new ArrayList<>();
		String choice = "";

		do {
			getMenu();
			System.out.println("Enter your choice:");
			choice = scanner.nextLine();

			switch (choice) {
			case "1":
				Brand brand = new Brand();
				
				System.out.println("Enter brand name: ");
				brand.setBrand_name(scanner.nextLine());
				System.out.println("Enter status: ");
				brand.setStatus(Integer.parseInt(scanner.nextLine()));
				
				boolean checkAdd = brandDAO.save(brand);
				if(checkAdd) {
					System.out.println("Saved success!");
				}else {
					System.out.println("Fail!");
				}
				break;
			case "2":

				Brand brand2 = new Brand();
				System.out.println("Enter brand name: ");
				brand2.setBrand_name(scanner.nextLine());
				System.out.println("Enter status: ");
				int id = Integer.parseInt(scanner.nextLine());
				brand2.setStatus(id);
				String loop="";
				do {
					Product product = new Product();
					System.out.println("Enter product id to update: ");
					product.setProduct_id(Integer.parseInt(scanner.nextLine()));
					System.out.println("Enter new product name: ");
					product.setProduct_name(scanner.nextLine());
					System.out.println("Enter new product year: ");
					product.setModel_year(scanner.nextLine());
					System.out.println("Enter new product price: ");
					product.setList_price(Double.parseDouble(scanner.nextLine()));
					products.add(product);
					
					System.out.println("Do you want to continue adding (Y|N)?");
					loop = scanner.nextLine();
				}while(loop.charAt(0) == 'Y' || loop.charAt(0) == 'y');
				brandDAO.save(brand2);
				productDAO.addProducts(products, id);
				
				break;
			case "3":
				boolean checkDel = brandDAO.delete();
				if(checkDel) {
					System.out.println("Delete success!");
				}else {
					System.out.println("Fail! Haven't brand inactive");
				}
				break;
			case "4":
				Product product = new Product();
				
				System.out.println("Enter product id to update: ");
				product.setProduct_id(Integer.parseInt(scanner.nextLine()));
				System.out.println("Enter new product name: ");
				product.setProduct_name(scanner.nextLine());
				System.out.println("Enter new product year: ");
				product.setModel_year(scanner.nextLine());
				System.out.println("Enter new product price: ");
				product.setList_price(Double.parseDouble(scanner.nextLine()));
				
				boolean checkUpdate = productDAO.update(product);
				if(checkUpdate) {
					System.out.println("Update success!");
				}else {
					System.out.println("not exist product id!");
				}
				break;
			case "6":
				System.exit(0);
				break;

			default:
				System.out.println("Invalid input!");
				break;
			}
		} while (true);
	}

	private static void getMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1. Add a new brand without a product");
		System.out.println("2. Add a new brand with products");
		System.out.println("3. Delete the brands that status is INACTIVE");
		System.out.println("4. Update an existing product");
		System.out.println("6. Close program");
	}

}
