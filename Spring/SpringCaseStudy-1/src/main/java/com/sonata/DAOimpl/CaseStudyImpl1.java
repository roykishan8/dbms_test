package com.sonata.DAOimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sonata.DAOIntf.CasestudyIntf;
import com.sonata.DBConnection.DbConnection;
import com.sonata.model.Login;
import com.sonata.model.Task;
import com.sonata.model.User;

@Service
public class CaseStudyImpl1 implements CasestudyIntf {
	public List<Task> getAllTask(){
		List<Task> tasklist=new ArrayList<>();
		try {
		DbConnection db=new DbConnection();
		PreparedStatement ps=db.getConnection().prepareStatement("Select * from Task");
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			Task task=new Task();
			task.setTaskId(res.getInt("taskId"));
			task.setName(res.getString("name"));
			task.setOwnerId(res.getInt("ownerId"));
			task.setIsBookmarked(res.getString("isbookmarked"));
			task.setStatus(res.getString("status"));
			task.setNotes(res.getString("notes"));
			task.setCreatedOn(res.getDate("createdon"));
			task.setPriority(res.getString("priority"));
			task.setDescription(res.getString("description"));
			task.setStatusChangedOn(res.getDate("statuschangedon"));
			tasklist.add(task);			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return tasklist;
	}
	
	public List<Login> getAllDetails(){
		List<Login> passlist=new ArrayList<>();
		try {
		DbConnection db=new DbConnection();
		PreparedStatement ps=db.getConnection().prepareStatement("Select * from pass");
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			Login task=new Login();
			task.setUserid(res.getInt("userid"));	
			task.setPassword(res.getString("password"));
			passlist.add(task);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return passlist;
		
	}
	
	public List<User> getAllUser(){
		List<User> userlist=new ArrayList<>();
		try {
		DbConnection db=new DbConnection();
		PreparedStatement ps=db.getConnection().prepareStatement("Select * from user");
		ResultSet res=ps.executeQuery();
		while(res.next()) {
			User task=new User();
			task.setUserId(res.getInt("userid"));
			task.setUsername(res.getString("username"));
			task.setEmail(res.getString("email"));
			task.setContactNumber(res.getLong("contactNo"));
			task.setRole(res.getString("role"));
			task.setActive(res.getBoolean("isActive"));
			task.setDOB(res.getDate("dob"));
			task.setCreate_On(res.getDate("createdon"));
			userlist.add(task);
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return userlist;
	}
	
}
