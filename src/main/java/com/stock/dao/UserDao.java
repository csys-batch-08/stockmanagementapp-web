package com.stock.dao;



import com.stock.model.User;

public interface UserDao {
	public  int insert(User users);
	public   User validateUser(User us);
	public void updated(User userupdate);
	
	
	
}
