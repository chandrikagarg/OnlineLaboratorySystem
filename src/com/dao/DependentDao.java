package com.dao;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Dependent;
import com.util.DatabaseUtil;
public class DependentDao {
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public boolean addDependent(Dependent d)
	{	
		conn=DatabaseUtil.getConnection();
		try {
			
			ps=conn.prepareStatement("insert into TBL_DEPENDENT_1465412 values(?,?,?,?,?,?,?,?,?,null");
			
			ps.setString(1, d.getPatientId());
			ps.setString(2, d.getFirstName());
			ps.setString(3, d.getLastName());
			ps.setString(4, d.getRelationShip());
			ps.setString(5, d.getGender());
			ps.setInt(6, d.getAge());
			ps.setString(7, d.getAddress());
			ps.setLong(8, d.getContactNumber());
			ps.setString(9, d.getInsuranceCover());
			if(d.getInsuranceCover().equalsIgnoreCase("yes"))
			{
				ps.setString(10, d.getHealthInsuranceNo());
			}
			
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public Dependent viewDependent(String id)
	{
		conn=DatabaseUtil.getConnection();
		try {
			
			 ps=conn.prepareStatement("select * from TBL_DEPENDENT_1465412  where PATIENT_ID=?");
			 ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				Dependent dep=new Dependent();
				dep.setFirstName(rs.getString("FIRST_NAME"));
				dep.setLastName(rs.getString("LAST_NAME"));
				dep.setRelationShip(rs.getString("RELATIONSHIP"));
				dep.setAge(rs.getInt("AGE"));
				dep.setAddress(rs.getString("ADDRESS"));
				dep.setContactNumber(rs.getLong("CONTACT_NO"));
				dep.setInsuranceCover(rs.getString("INSURANCE_COVER"));
				dep.setHealthInsuranceNo(rs.getString("HEALTH_INSURANCE_NO"));
				return dep;
				
			}
		
	}catch (Exception e) {
		// TODO: handle exception
	}	
	return null;

}
	
	
	
	
	public boolean updateDependent(Dependent d)
	{
		conn=DatabaseUtil.getConnection();
		try {
			
			PreparedStatement ps1=conn.prepareStatement("slect  ");
			String dependentId=null;
			ResultSet rs=ps1.executeQuery();
			while(rs.next())
			{
				
				dependentId =rs.getString("id");
			}
			
			ps=conn.prepareStatement("update TBL_DEPENDENT_1465412 set FIRST_NAME=?,LAST_NAME=?,RELATIONSHIP=?,GENDER=?,AGE=?,ADDRESS=?,CONTACT_NO=?,INSURANCE_COVER=?,HEALTH_INSURANCE_NO=? where PATIENT_ID=? ");
			
			
			ps.setString(1, d.getFirstName());
			ps.setString(2, d.getLastName());
			ps.setString(3, d.getRelationShip());
			ps.setString(4, d.getGender());
			ps.setInt(5, d.getAge());
			ps.setString(6, d.getAddress());
			ps.setLong(7, d.getContactNumber());
			ps.setString(8, d.getInsuranceCover());
			ps.setString(9, d.getHealthInsuranceNo());
			ps.setString(10, d.getPatientId());
			int i=ps.executeUpdate();
			if(i>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	

}
