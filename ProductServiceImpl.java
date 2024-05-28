package com.rps.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rps.client.Product;
import com.rps.utilpack.DbConn;

public class ProductServiceImpl implements ProductService  {
	
	
	public void insertProduct(Product prod) throws SQLException,ClassNotFoundException{
		//PreparedStatement
		PreparedStatement pst=DbConn.getConnection().prepareStatement("insert into Product values(?,?,?)");
		pst.setInt(1,prod.getProd_id());
		pst.setString(2,prod.getProd_name());
		pst.setInt(3,prod.getPrice());
		pst.execute();
		
	}

public void deleteProduct(Integer prod_id)throws SQLException,ClassNotFoundException {
	PreparedStatement pst=DbConn.getConnection().prepareStatement("delete from Product where id=?");
	pst.setInt(1,prod_id);
	pst.execute();
	//implement logger
	System.out.println("deleted");
	}
	public void updateProduct(Integer prod_id,Product prod) throws SQLException,ClassNotFoundException{
		Connection con=DbConn.getConnection();
		con.setAutoCommit(false);
		try {
		PreparedStatement pst=con.prepareStatement("update  Product  prod_name=?,price=? where prod_id=?");
		pst.setInt(3,prod_id);
		pst.setString(2, prod.getProd_name());
		pst.setInt(3, prod.getPrice());
		pst.execute();
		}
		catch(Exception e) {
			con.rollback();
		}
		con.commit();
		//implement logger
		System.out.println("deleted");	
	}
	public List<Product> getAllProduct()throws SQLException,ClassNotFoundException{
		Statement st=DbConn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=st.executeQuery("select * from Product");
		List<Product> plist=new ArrayList<>();
		while(rs.next()) {
		
			Product p=new Product();
			p.setProd_id(rs.getInt(1));
			p.setProd_name(rs.getString(2));
			p.setPrice(rs.getInt(3));
			plist.add(p);
		}
		return plist;
	}
	public Product getProduct(Integer prod_id)throws SQLException,ClassNotFoundException {
		PreparedStatement st=DbConn.getConnection().prepareStatement("select * from Product where id=?");
		st.setInt(1, prod_id);
		
		ResultSet rs=st.executeQuery();
		Product p=new Product();
		
		while(rs.next()) {
			p.setProd_id(rs.getInt(1));
			p.setProd_name(rs.getString(2));
			p.setPrice(rs.getInt(3));
		}
		
		return p;
	}

}
