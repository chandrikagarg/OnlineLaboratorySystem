package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.bean.*;
import com.bean.HealthCareProvider;
import com.password.PasswordGenerator;
import com.util.DatabaseUtil;
public class HcpDao {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String id;
	String id1 = null;
	public boolean registerHcp(HealthCareProvider h)
	{
		con = DatabaseUtil.getConnection();
		String query = "INSERT INTO TBL_HCP_1465039 VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			id = nextHcpId();
			ps= con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2,h.getHcpName());
			ps.setString(3, h.getLicenseNo());
			ps.setString(4, h.getAddress());
			ps.setLong(5, h.getContactNo());
			ps.setLong(6, h.getAlternateContactNo());
			ps.setString(7, h.getEmailId());
			ps.setString(8, h.getQuestion1());
			ps.setString(9, h.getAnswer1());
			ps.setString(10, h.getQuestion2());
			ps.setString(11, h.getAnswer2());
			int i = ps.executeUpdate();
			if(i>0)
			{
				registerIdandPassword();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(con);
		}
		return false;
	}
	private boolean registerIdandPassword() {
		con = DatabaseUtil.getConnection();
		String query = "INSERT INTO LOGIN_HCP_1465039 VALUES(?,?)";
		try {
			String password = PasswordGenerator.passwordGen();
			ps= con.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2,password);
			int i = ps.executeUpdate();
			if(i>0)
			{
				
				PreparedStatement ps3=con.prepareStatement("insert into FORGOTPASSWORD values(?,?)");
				ps3.setString(1, id1);
				ps3.setString(2, "hcp");
				ps3.executeUpdate();
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(con);
		}
		
		return false;
	}
	private String nextHcpId() {
	
		con = DatabaseUtil.getConnection();
		String query = "SELECT HCP_ID.NEXTVAL FROM DUAL";
		try {
			ps= con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next())
			{
				 id1 = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id1;
	}
	
	
	
	
	
	public boolean changePasswordHcp(String id,String currentPassword,String newPassword)
	{
		String password=null;
			System.out.println("inside hcppp");
		con=DatabaseUtil.getConnection();

		String query1="update LOGIN_HCP_1465039 set PASSWORD =? where HCP_ID=?";
		try {
				ps=con.prepareStatement(query1);
				ps.setString(1, newPassword);
				ps.setString(2,id);
				int i=ps.executeUpdate();
				if(i>0)
				{
					return true;
				}
			}
	catch (SQLException e) {
			e.printStackTrace();
		}
		finally
		{
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(ps);
			DatabaseUtil.closeConnection(con);
		}
		return false;
	}
	

	
	public String matchQuestionAndGetPassword(String hcpId,String question1,String answer1,String question2,String answer2)
	{
		con = DatabaseUtil.getConnection();
		String answerone = null;
		String answertwo = null;
		String password;
		String query = "SELECT ANSWER1 FROM TBL_HCP_1465039 WHERE HCP_ID=? AND QUESTION1=?";
		String query1 ="SELECT ANSWER2 FROM TBL_HCP_1465039 WHERE HCP_ID=? AND QUESTION2=?";
		String query2="SELECT PASSWORD FROM LOGIN_HCP_1465039 WHERE HCP_ID=?";
		
		try {
			PreparedStatement ps1=con.prepareStatement(query);
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next())
			{
			 answerone=rs1.getString("ANSWER1");
			PreparedStatement ps2=con.prepareStatement(query);
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next())
			{
				answertwo = rs2.getString("ANSWER2");
			}

			}
			if(answerone.equalsIgnoreCase(answer1)&& answertwo.equalsIgnoreCase(answer2))
			{
				PreparedStatement ps3 = con.prepareStatement(query2);
				ResultSet rs3 = ps3.executeQuery();
				while(rs3.next())
				{
					password = rs.getString("PASSWORD");
					return password;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	
	
	public boolean loginAsHCP(String userName,String password)
	{
		con=DatabaseUtil.getConnection();
		String currPassword=null;
		try {
			
			
		
			
			ps=con.prepareStatement(" select PASSWORD from LOGIN_HCP_1465039 where HCP_ID=?");
			ps.setString(1, userName);
			
			ResultSet rs1=ps.executeQuery();
			
			while(rs1.next())
			{	
				currPassword=rs1.getString("PASSWORD");	
			}
		
			if(currPassword.equals(password))
			{
				
				return true;
				
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		return false;
		
	}
	
	public HealthCareProvider hcp(String id2)
	{
		ArrayList<HealthCareProvider> list = new ArrayList<>();
		con = DatabaseUtil.getConnection();
		String query ="SELECT HCP_ID,HCP_NAME,LICENSE_NO,ADDRESS,CONTACT_NO,ALTERNATE_NO,EMAIL_ID FROM TBL_HCP_1465039 WHERE HCP_ID = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, id2);
			rs = ps.executeQuery();
			while(rs.next())
			{
				String hcpid= rs.getString("HCP_ID");
				String hcpName=rs.getString("HCP_NAME");
				String hcpLicense = rs.getString("LICENSE_NO");
				String address = rs.getString("ADDRESS");
				long con = rs.getLong("CONTACT_NO");
				long alt = rs.getLong("ALTERNATE_NO");
				String email = rs.getString("EMAIL_ID");
				HealthCareProvider hcp = new HealthCareProvider(hcpid, hcpName, hcpLicense, address, con, alt, email);
				System.out.println(hcp);

				return hcp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		}
	
	public boolean updateHcp(HealthCareProvider h){
		con=DatabaseUtil.getConnection();
		String query = "UPDATE  TBL_HCP_1465039 SET HCP_NAME=?,LICENSE_NO=?,ADDRESS=?,CONTACT_NO=?,ALTERNATE_NO=?,EMAIL_ID=? WHERE HCP_ID=?";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, h.getHcpName());
			ps.setString(2, h.getLicenseNo());
			ps.setString(3, h.getAddress());
			ps.setLong(4, h.getContactNo());
			ps.setLong(5, h.getAlternateContactNo());
			ps.setString(6, h.getEmailId());
			ps.setString(7, h.getHcpId());
			int i = ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public Patient SearchPatient(String value)
	{
		
		Patient p = null;
		
		con=DatabaseUtil.getConnection();
		try {
			ps = con.prepareStatement("Select PATIENT_ID,FIRST_NAME,LAST_NAME,GENDER,AGE,ADDRESS,CONTACT_NO,MEDICAL_COMPLAINT,REFERRED_DOCTOR,INSURANCE_COVER,HEALTH_INSURANCE_NO from TBL_patient_1465412  where PATIENT_ID=? OR CONTACT_NO=?");
			ps.setString(1, value);
			
			long value1=Long.parseLong(value);
			System.out.println("valuejjj" +value1);
			ps.setLong(2,value1);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				if(p==null)
				{
					p=new Patient();
				}
				System.out.println("****");
				p.setPatientId(rs.getString("PATIENT_ID"));
				p.setFirstName(rs.getString("FIRST_NAME"));
				p.setLastName(rs.getString("LAST_NAME"));
				p.setGender(rs.getString("GENDER"));
				p.setAge(rs.getInt("AGE"));
				p.setAddress(rs.getString("ADDRESS"));
				p.setContactNumber(rs.getLong("CONTACT_NO"));
				p.setMedicalComplaint(rs.getString("MEDICAL_COMPLAINT"));
				p.setReferredDoctor(rs.getString("REFERRED_DOCTOR"));
				p.setInsuranceCover(rs.getString("INSURANCE_COVER"));
				System.out.println("INSURANCE_COVER");
				p.setHealthInsuranceNo(rs.getString("HEALTH_INSURANCE_NO"));
				System.out.println("****");
				System.out.println("p" +p);
			
			}
				
				
			}catch (SQLException e) {
				System.out.println(e.getMessage());
				
			}finally{
				DatabaseUtil.closePreparedStatement(ps);
				DatabaseUtil.closeConnection(con);
				
			}
			
		return p;
		
	}
	
	
	
			
	}
	


	
	

