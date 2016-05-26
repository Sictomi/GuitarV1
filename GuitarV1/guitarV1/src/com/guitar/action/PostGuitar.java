package com.guitar.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.guitar.action.Guitar;

import java.sql.*;
import java.util.*;

import com.guitar.dao.SearchGuitar;
import com.guitar.util.JDBCsqlite;


import javax.servlet.*;

/**
 * Servlet implementation class GuitarPost
 */
@WebServlet("/GuitarPost")
public class PostGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;     
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostGuitar() {
        super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8");
			
		String builder = request.getParameter("size");
		String type = request.getParameter("type");
		String backwood = request.getParameter("backwood");
		String topwood = request.getParameter("topwood");
		
	 if(!getGuitars(builder,backwood,topwood,type).isEmpty()){
		request.setAttribute("guitars", getGuitars(builder,backwood,topwood,type));
		request.getRequestDispatcher("/ShowGuitar.jsp").forward(request, response);
	 }
	}
	
	public static List<Guitar> getGuitars(String builder, String backwood, String topwood, String type){
		JDBCsqlite jdbc = new JDBCsqlite();
		Connection connection = jdbc.connection;
		PreparedStatement ps = null;
		
		List<Guitar> guitars = new ArrayList<Guitar>();
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
					ps = connection.prepareStatement("select * from Guitar where backwood=? and type=?");
					ps.setString(1, backwood);
					ps.setString(2, type);
				}
				if(builder== "" && backwood!= "" && topwood!= "" && type== ""){
					ps = connection.prepareStatement("select * from Guitar where backwood=? and topwood=?");
					ps.setString(1, backwood);
					ps.setString(2, type);
				}
				if(builder!= "" && backwood== "" && topwood== "" && type!= ""){
					ps = connection.prepareStatement("select * from Guitar where builder=? and type=?");
					ps.setString(1, builder);
					ps.setString(2, type);
				}
				if(builder!= "" && backwood== "" && topwood!= "" && type== ""){
					ps = connection.prepareStatement("select * from Guitar where builder=? and topwood=?");
					ps.setString(1, builder);
					ps.setString(2, topwood);
				}
				if(builder!= "" && backwood!= "" && topwood== "" && type== ""){
					ps = connection.prepareStatement("select * from Guitar where builder=? and backwood=?");
					ps.setString(1, builder);
					ps.setString(2, topwood);
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
					Guitar guitar = new Guitar();
					
				
					guitar.setBackWood(rs.getString(2));
					guitar.setTopWood(rs.getString(3));
					guitar.setPrice(rs.getDouble(4));
					guitar.setBuilder(rs.getString(5));
					guitar.setModel(rs.getString(6));
					guitar.setType(rs.getString(7));
				
								
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