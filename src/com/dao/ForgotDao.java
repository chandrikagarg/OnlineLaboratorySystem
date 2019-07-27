package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DatabaseUtil;

public class ForgotDao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public String validate(String id)
	{
		System.out.println("inside validate");
		System.out.println(id);
			String role=null;
		conn=DatabaseUtil.getConnection();
		
		
		
		try {
			ps=conn.prepareStatement("select role from FORGOTPASSWORD where ID=?");
			ps.setString(1, id);
			
		rs=	ps.executeQuery();
		while(rs.next())
		{			
			role=rs.getString("role");		
		}
		
		
		} catch (SQLException e) {
			return null;
		}
		
		return role;
}
	
	
	public String[] matchQuestionAndGetAnswers(String Id)
	{
		conn = DatabaseUtil.getConnection();
		String answerone = null;
		String answertwo = null;
		String[] answers=new String[50];
		
		String query1 = "SELECT ANSWER1 FROM TBL_patient_1465412 WHERE PATIENT_ID=? ";
		String query2 ="SELECT ANSWER2 FROM TBL_patient_1465412 WHERE PATIENT_ID=? ";
	
		
		//	String query2="SELECT PASSWORD FROM LOGIN_HCP_1465039 WHERE HCP_ID=?";
		
		try {
			PreparedStatement ps1=conn.prepareStatement(query1);
			ps1.setString(1, Id);
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next())
			{
				 answerone=rs1.getString("ANSWER1");
				PreparedStatement ps2=conn.prepareStatement(query2);
				ps2.setString(1, Id);
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next())
				{
					answertwo = rs2.getString("ANSWER2");
				}
			}
			
			answers[0]=answerone;
			answers[1]=answertwo;
			
		
	}catch (Exception e) {
		// TODO: handle exception
	}
	
	
		return answers;
	
}
	
	public String[] matchQuestionAndGetAnswersForHcp(String Id)
	{
		conn = DatabaseUtil.getConnection();
		String answerone = null;
		String answertwo = null;
		String[] answers=new String[50];
		
		String query1 = "SELECT ANSWER1 FROM TBL_HCP_1465039 WHERE HCP_ID=? ";
		String query2 ="SELECT ANSWER2 FROM TBL_HCP_1465039 WHERE HCP_ID=? ";
	
		
		//	String query2="SELECT PASSWORD FROM LOGIN_HCP_1465039 WHERE HCP_ID=?";
		
		try {
			PreparedStatement ps1=conn.prepareStatement(query1);
			ps1.setString(1, Id);
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next())
			{
				 answerone=rs1.getString("ANSWER1");
				PreparedStatement ps2=conn.prepareStatement(query2);
				ps2.setString(1, Id);
				ResultSet rs2=ps2.executeQuery();
				while(rs2.next())
				{
					answertwo = rs2.getString("ANSWER2");
				}
			}
			
			answers[0]=answerone;
			answers[1]=answertwo;
			
		
	}catch (Exception e) {
		// TODO: handle exception
	}
	
	
		return answers;
	
}
	
	
	
	
	public boolean match(String answer1,String answer2,String[] answers)
	{
		
		if(answer1.equalsIgnoreCase(answers[0]) && answer2.equalsIgnoreCase(answers[1]))
		{
			
			return true;
		}
			
		return false;
	}
	
	
	
	public boolean forgotpassword(String id,String newpwd)
	{
		System.out.println("inside forgotpwd");
		
		
		conn = DatabaseUtil.getConnection();
		
		try {
			ps=conn.prepareStatement("update LOGIN_PATIENT_1465412 set PASSWORD=? where PATIENT_ID=?");
			ps.setString(1, newpwd);
			ps.setString(2, id);
			int i=ps.executeUpdate();
		if(i>0) return true;
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;			
		
	}
	
	
	public boolean forgotpasswordforHcp(String id,String newpwd)
	{
		System.out.println("inside forgotpwd");
		
		
		conn = DatabaseUtil.getConnection();
		
		try {
			ps=conn.prepareStatement("update LOGIN_HCP_1465039 set PASSWORD=? where HCP_ID=?");
			ps.setString(1, newpwd);
			ps.setString(2, id);
			int i=ps.executeUpdate();
		if(i>0) return true;
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;			
		
	}
	
	
	
	
}