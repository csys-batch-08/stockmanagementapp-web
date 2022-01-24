package com.stock.dao;

import java.sql.ResultSet;

import com.stock.model.User;

public interface UserDao {
	public  int insert(User users);
	public   ResultSet validateUser(User us);
	public void updated(User userupdate);
	public void delete(User userdelete);
	
	
}
