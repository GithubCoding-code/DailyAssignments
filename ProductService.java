package com.rps.service;

import java.sql.SQLException;
import java.util.List;

import com.rps.client.Product;


public interface ProductService {
	
	void insertProduct(Product prod) throws SQLException,ClassNotFoundException;
	void deleteProduct(Integer prod_id)throws SQLException,ClassNotFoundException ;
	void updateProduct(Integer prod_id,Product prod)throws SQLException,ClassNotFoundException ;
	List<Product> getAllProduct()throws SQLException,ClassNotFoundException;
	Product getProduct(Integer prod_id) throws SQLException,ClassNotFoundException;


}
