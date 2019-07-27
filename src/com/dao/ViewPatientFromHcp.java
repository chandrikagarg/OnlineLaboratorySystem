package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Patient;
import com.util.DatabaseUtil;

public class ViewPatientFromHcp {
	
	
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	
	public ArrayList<Patient> viewPatient(String id)
	{
		ResultSet rs1=null;
		PreparedStatement ps1=null;
		System.out.println("inside view patient");
		ArrayList<Patient> temp=new ArrayList<Patient>();
		
		String[] patientIdArray=new String[50];
		int i=0;
		
		conn=DatabaseUtil.getConnection();
		try {
			ps=conn.prepareStatement("select PATIENT_ID from HCP_PATIENT where HCP_ID=?");
			ps.setString(1, id);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				
				patientIdArray[i]=rs.getString("PATIENT_ID");
				i++;
				
			}
			System.out.println(patientIdArray[0]);
			System.out.println(patientIdArray[1]);
			int k=0;
			
			if(patientIdArray.length>0)
			{
				for(int j=0;j<patientIdArray.length;j++)
				{
					ps1=conn.prepareStatement("select * from TBL_patient_1465412 where patient_id=?");
					ps1.setString(1, patientIdArray[j]);
					
				rs1=ps1.executeQuery();
					while(rs1.next())
					{
						
						String idPatient = rs1.getString("PATIENT_ID");
						String firstName = rs1.getString("FIRST_NAME");
						String lastName = rs1.getString("LAST_NAME");
						String gender = rs1.getString("GENDER");
						int age = rs1.getInt("AGE");
						String address = rs1.getString("ADDRESS");
						long contact = rs1.getLong("CONTACT_NO");
						String medical_complaint = rs1.getString("MEDICAL_COMPLAINT");
						String doctor=rs1.getString("REFERRED_DOCTOR");
						String insuranceCover=rs1.getString("INSURANCE_COVER");
						String healthInsurNo=rs1.getString("HEALTH_INSURANCE_NO");
						
						Patient p = new Patient(idPatient, firstName, lastName, gender, age, address, contact, medical_complaint,doctor,insuranceCover,healthInsurNo);
					
						temp.add(p);
						
					}
				}										
			}
			else
			{
						
				return null;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return temp;
	}
	

}
