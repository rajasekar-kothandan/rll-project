package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MenuDAO {

	
	Connection connection;
	PreparedStatement pst;
	public List<Menu> showMenu(int restaurantId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from menu where RESTAURANTID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, restaurantId);
		ResultSet rs = pst.executeQuery();
		List<Menu> menuList = new ArrayList<Menu>();
		Menu menu = null;
		while(rs.next()) {
			menu = new Menu();
			menu.setMenuId(rs.getInt("menuid"));
			menu.setRestaurantId(rs.getInt("restaurantid"));
			menu.setItemName(rs.getString("itemname"));
			menu.setMenutype(rs.getString("menutype"));
			menu.setCalories(rs.getInt("calories"));
			menu.setPrice(rs.getInt("Price"));
			menuList.add(menu);
		}
		return menuList;
	}
	
	
	public Menu searchMenu(int menuId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from menu where menuid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, menuId);
		ResultSet rs = pst.executeQuery();
		Menu menu = null;
		if(rs.next()) {
			menu = new Menu();
			menu.setMenuId(rs.getInt("menuid"));
			menu.setRestaurantId(rs.getInt("restaurantid"));
			menu.setItemName(rs.getString("itemname"));
			menu.setMenutype(rs.getString("menutype"));
			menu.setCalories(rs.getInt("calories"));
			menu.setPrice(rs.getInt("Price"));
		}
		return menu;
		
	}
	
	
	
	
}
