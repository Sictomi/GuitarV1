package com.guitar.dao;

import java.sql.*;
import java.util.*;

import com.guitar.util.JDBCsqlite;
import com.system.ass.*;

import javax.servlet.*;

public class SearchGuitar {
	private static Connection connection = null;
	private JDBCsqlite jdbc = null;
	private static PreparedStatement ps = null;
	
	public SearchGuitar(){
		jdbc = new JDBCsqlite();
		connection= jdbc.connection;
	}
	
	public static List<Guitar> getGuitars(String builder, String backwood, String topwood, String type){
		List<Guitar> guitars = new ArrayList<Guitar>();
		Guitar guitar = null;
			try {
				//全有
				if(builder!= "" && backwood!= "" && topwood!= "" && type!= ""){
					ps = connection.prepareStatement("select * from Guitar where builder=? and backwood=? and topwood=? and type=?");
					ps.setString(1, builder);
					ps.setString(2, backwood);
					ps.setString(3, topwood);
					ps.setString(4, type);
				}
				//一个为空
				if(builder=="" && backwood!= "" && topwood!= "" && type!= ""){
					ps = connection.prepareStatement("select * from Guitar where backwood=? and topwood=? and type=?");
					ps.setString(1, backwood);
					ps.setString(2, topwood);
					ps.setString(3, type);
				}
				if(builder!= "" && backwood== "" && topwood!= "" && type!= ""){
					ps = connection.prepareStatement("select * from Guitar where builder=? and topwood=? and type=?");
					ps.setString(1, builder);
					ps.setString(2, topwood);
					ps.setString(3, type);
				}
				if(builder!= "" && backwood!= "" && topwood== "" && type!= ""){
					ps = connection.prepareStatement("select * from Guitar where builder=? and backwood=? and type=?");
					ps.setString(1, builder);
					ps.setString(2, backwood);
					ps.setString(3, type);
				}
				if(builder!= "" && backwood!= "" && topwood!= "" && type== ""){
					ps = connection.prepareStatement("select * from Guitar where builder=? and backwood=? and topwood=?");
					ps.setString(1, builder);
					ps.setString(2, backwood);
					ps.setString(3, topwood);
				}
				//两个为空
				if(builder== "" && backwood== "" && topwood!= "" && type!= ""){
					ps = connection.prepareStatement("select * from Guitar where topwood=? and type=?");
					ps.setString(1, topwood);
					ps.setString(2, type);
				}
				if(builder== "" && backwood!= "" && topwood== "" && type!= ""){
					ps = connection.prepareStatement("select * from Guitar where builder=? and topwood=?");
					ps.setString(1, builder);
					ps.setString(2, topwood);
				}
				if(builder== "" && backwood!= "" && topwood!= "" && type== ""){
					ps = connection.prepareStatement("select * from Guitar where builder=? and type=?");
					ps.setString(1, builder);
					ps.setString(2, type);
				}
				if(builder!= "" && backwood== "" && topwood== "" && type!= ""){
					ps = connection.prepareStatement("select * from Guitar where backwood=? and topwood=?");
					ps.setString(1, backwood);
					ps.setString(2, topwood);
				}
				if(builder!= "" && backwood== "" && topwood!= "" && type== ""){
					ps = connection.prepareStatement("select * from Guitar where backwood=? and type=?");
					ps.setString(1, backwood);
					ps.setString(2, type);
				}
				if(builder!= "" && backwood!= "" && topwood== "" && type== ""){
					ps = connection.prepareStatement("select * from Guitar where topwood=? and type=?");
					ps.setString(1, topwood);
					ps.setString(2, type);
				}
				//三个为空
				if(builder=="" && backwood== "" && topwood== "" && type!= ""){
					ps = connection.prepareStatement("select * from Guitar where type=?");
					ps.setString(1, type);
				}
				if(builder== "" && backwood== "" && topwood!= "" && type== ""){
					ps = connection.prepareStatement("select * from Guitar where topwood=?");
					ps.setString(1, topwood);
				}
				if(builder== "" && backwood!= "" && topwood== "" && type== ""){
					ps = connection.prepareStatement("select * from Guitar where backwood=?");
					ps.setString(1, backwood);
				}
				if(builder!= "" && backwood== "" && topwood== "" && type== ""){
					ps = connection.prepareStatement("select * from Guitar where backwood=?");
					ps.setString(1, builder);
				}
				
				//全空
				if(builder=="" && backwood== "" && topwood== "" && type== ""){
					ps = connection.prepareStatement("select * from Guitar");
				}
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					guitar = new Guitar();
					
					guitar.setSerialNumber(rs.getString(2));
					guitar.setBackWood(rs.getString(3));
					guitar.setTopWood(rs.getString(4));
					guitar.setPrice(rs.getDouble(5));
					guitar.setBuilder(rs.getString(6));
					guitar.setModel(rs.getString(7));
					guitar.setType(rs.getString(8));
								
					guitars.add(guitar);			
				}
				if(rs != null){
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return guitars;
	}
}