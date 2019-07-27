package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.bean.Dependent;
import com.bean.Patient;
import com.password.PasswordGenerator;
import com.util.DatabaseUtil;

public class Patientdao {
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	public String[] addPatient(Patient p)
	{
		String[] value=new String[50];
		
		conn=DatabaseUtil.getConnection();
		String patientId=null;
		PreparedStatement ps1=null;
		try {
			ps1 = conn.prepareStatement("select PATIENT_ID.nextval as id from dual");
			rs=ps1.executeQuery();
			while(rs.next())
			{
				patientId=rs.getString("id");
			
				
			}
			ps=conn.prepareStatement("insert into TBL_patient_1465412 values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			p.setPatientId(patientId);
			ps.setString(1, patientId);
			ps.setString(2, p.getFirstName());
			ps.setString(3, p.getLastName());
			ps.setString(4, p.getGender());
			ps.setInt(5, p.getAge());
			ps.setString(6, p.getAddress());
			ps.setLong(7, p.getContactNumber());
			ps.setString(8, p.getMedicalComplaint());
			ps.setString(9, p.getReferredDoctor());
			ps.setString(10, p.getInsuranceCover());
			ps.setString(11, p.getHealthInsuranceNo());
			ps.setString(12, p.getQuestion1());
			ps.setString(13, p.getAnswer1());
			ps.setString(14, p.getQuestion2());
			ps.setString(15, p.getAnswer2());
			
			int i=ps.executeUpdate();
			
			
			if(i>0)
			{
				PreparedStatement ps2=conn.prepareStatement("insert into LOGIN_PATIENT_1465412 values(?,?)");
				ps2.setString(1, p.getPatientId());
				String password=PasswordGenerator.passwordGen();
				ps2.setString(2, password);		
						int j=ps2.executeUpdate();
						if(j>0)
						{
							
							PreparedStatement ps3=conn.prepareStatement("insert into FORGOTPASSWORD values(?,?)");
								ps3.setString(1, patientId);
								ps3.setString(2, "patient");
								ps3.executeUpdate();
							value[0]=patientId;
							value[1]=password;
							return value;										
						}				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(conn);
		}
		return null;
	}
	public String[] addPatientByHcp(Patient p,String hcpId)
	{
		String[] value=new String[50];
		
		conn=DatabaseUtil.getConnection();
		String patientId=null;
		PreparedStatement ps1=null;
		try {
			ps1 = conn.prepareStatement("select PATIENT_ID.nextval as id from dual");
			rs=ps1.executeQuery();
			while(rs.next())
			{
				patientId=rs.getString("id");
			
				
			}
			ps=conn.prepareStatement("insert into TBL_patient_1465412 values(?,?,?,?,?,?,?,?,?,?,?,null,null,null,null)");
			p.setPatientId(patientId);
			ps.setString(1, patientId);
			ps.setString(2, p.getFirstName());
			ps.setString(3, p.getLastName());
			ps.setString(4, p.getGender());
			ps.setInt(5, p.getAge());
			ps.setString(6, p.getAddress());
			ps.setLong(7, p.getContactNumber());
			ps.setString(8, p.getMedicalComplaint());
			ps.setString(9, p.getReferredDoctor());
			ps.setString(10, p.getInsuranceCover());
			ps.setString(11, p.getHealthInsuranceNo());
			
			
			int i=ps.executeUpdate();
			System.out.println("patient table value added"+i);
			
			if(i>0)
			{
				PreparedStatement ps2=conn.prepareStatement("insert into LOGIN_PATIENT_1465412 values(?,?)");
				ps2.setString(1, p.getPatientId());
				String password=PasswordGenerator.passwordGen();
				ps2.setString(2, password);		
						int j=ps2.executeUpdate();
						if(j>0)
						{
							System.out.println("Login patient value added"+j);
							
							PreparedStatement ps3=conn.prepareStatement("insert into FORGOTPASSWORD values(?,?)");
								ps3.setString(1, patientId);
								ps3.setString(2, "patient");
								
								int k = ps3.executeUpdate();
								if(k>0){
									{
										System.out.println("enterred value to forgot"+k);
										PreparedStatement ps4 = conn.prepareStatement("insert into hcp_patient values(?,?)");
										ps4.setString(1, patientId);
										ps4.setString(2, hcpId);
										int l = ps4.executeUpdate();
										if(l>0)
										{
											System.out.println("entered value to table hcp_login"+l);
											value[0]=patientId;
											value[1]=password;
											return value;
										}
										
									}
							
						}				
			}
		}
		}catch (SQLException e) {
			
			e.printStackTrace();
		}finally
		{
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(conn);
		}
		return null;
	}
	
	public boolean changePassword(String id,String currentPassword,String newPassword)
	{
		String password=null;
			
		conn=DatabaseUtil.getConnection();
		try {
			System.out.println("inside change password");
			
			
				ps=conn.prepareStatement("update LOGIN_PATIENT_1465412 set PASSWORD =? where PATIENT_ID=?");
		
				ps.setString(1, newPassword);
				ps.setString(2,id);
				
				int i=ps.executeUpdate();
				if(i>0)
				{
					
					return true;
					
				}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
				
	}
	
	public boolean loginAsPatient(String userName,String password)
	{
			Connection conn = null;
			PreparedStatement ps=null;
		conn=DatabaseUtil.getConnection();
		String currPassword=null;
		try {
			
			
		
			
			ps=conn.prepareStatement("select PASSWORD from LOGIN_PATIENT_1465412 where PATIENT_ID=?");
			ps.setString(1, userName);
			
			ResultSet rs1=ps.executeQuery();
			
			while(rs1.next())
			{	
				currPassword=rs1.getString("PASSWORD");	
			}
		
			if(currPassword==null)return false;
			if(currPassword.equals(password))
			{
				
				return true;
				
			}		
			
		} catch (SQLException e) {
			
			return false;
		}
					
		return false;
		
	}
	/*DEPENDENT_ID varchar2(10) primary key,
	FIRST_NAME varchar2(30) not null,
	LAST_NAME  varchar2(30) not null,
	RELATIONSHIP  varchar2(30) not null,
	GENDER varchar2(30) not null,
	AGE NUMBER(10),
	ADDRESS varchar2(100) not null,
	CONTACT_NO number(10),
	INSURANCE_COVER varchar2(30) ,
	HEALTH_INSURANCE_NO varchar2(30),
	PATIENT_ID REFERENCES TBL_patient_1465412(PATIENT_ID)
	
	*/
	public boolean adddependent(String userId,Dependent d )
	{
		boolean flag=false;
		conn=DatabaseUtil.getConnection();
		String query= "INSERT INTO TBL_DEPENDENT_1465412 VALUES (?,?,?,?,?,?,?,?,?,?)";
		try 
		{
			ps=conn.prepareStatement(query);
			ps.setString(1, d.getFirstName());
			ps.setString(2, d.getLastName());
			ps.setString(3, d.getRelationShip());
			ps.setString(4, d.getGender());
			ps.setInt(5, d.getAge());
			ps.setString(6, d.getAddress());
			ps.setLong(7, d.getContactNumber());
			ps.setString(8, d.getInsuranceCover());
			ps.setString(9, d.getHealthInsuranceNo());
			ps.setString(10, userId);
			d.setPatientId(userId);
			int i=ps.executeUpdate();
			if(i>0)
			{
				flag=true;
			}
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	public Patient viewPatient(String id)
	{
		conn= DatabaseUtil.getConnection();
		String query="SELECT PATIENT_ID,FIRST_NAME,LAST_NAME,GENDER,AGE,ADDRESS,CONTACT_NO,MEDICAL_COMPLAINT FROM TBL_patient_1465412 WHERE PATIENT_ID=? ";
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, id);
			rs= ps.executeQuery();
			while(rs.next())
			{
				String idPatient = rs.getString("PATIENT_ID");
				String firstName = rs.getString("FIRST_NAME");
				String lastName = rs.getString("LAST_NAME");
				String gender = rs.getString("GENDER");
				int age = rs.getInt("AGE");
				String address = rs.getString("ADDRESS");
				long contact = rs.getLong("CONTACT_NO");
				String medical_complaint = rs.getString("MEDICAL_COMPLAINT");
				Patient p = new Patient(idPatient, firstName, lastName, gender, age, address, contact, medical_complaint);
				System.out.println(p);
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	public boolean updatePatientDetails(Patient p1, String pId) 
	{
		boolean flag=false;
		conn=DatabaseUtil.getConnection();
		String query="UPDATE TBL_patient_1465412 SET FIRST_NAME=?,LAST_NAME=?,GENDER=?,AGE=?,ADDRESS=?,CONTACT_NO=?,MEDICAL_COMPLAINT=?,"
				+ "REFERRED_DOCTOR=?,INSURANCE_COVER=?,HEALTH_INSURANCE_NO=? WHERE PATIENT_ID=?" ;
		try
		{
			ps=conn.prepareStatement(query);
			ps.setString(1, p1.getFirstName());
			
			ps.setString(2, p1.getLastName());
			ps.setString(3, p1.getGender());
			ps.setInt(4, p1.getAge() );
			ps.setString(5, p1.getAddress());
			ps.setLong(6, p1.getContactNumber());
			ps.setString(7, p1.getMedicalComplaint());
			ps.setString(8, p1.getReferredDoctor());
			ps.setString(9, p1.getInsuranceCover());
			ps.setString(10, p1.getHealthInsuranceNo());
			ps.setString(11, pId);
			int i=ps.executeUpdate();
			if(i>0)
			{
				flag=true;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(conn);
		}
		return flag;
	}
	


	public boolean deletePatient(String id)
	{


		Connection conn = null;
		PreparedStatement ps=null;
		double k=0;
	
		conn= DatabaseUtil.getConnection();
		try{
		ps=conn.prepareStatement("Select PAYMENT_PENDING from payment where PATIENT_ID=?");
		ps.setString(1, id);
		rs= ps.executeQuery();
		while(rs.next())
		{
			 k=rs.getDouble("PAYMENT_PENDING");
			 System.out.println(k);
			 
		}
		if(k==0.0)
		{
			ps=conn.prepareStatement("delete  from TBL_patient_1465412 where Patient_id=?");
			ps.setString(1, id);
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			
		}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	
	}


	
	
}
