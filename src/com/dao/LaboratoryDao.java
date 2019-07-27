package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Laboratory;
import com.bean.Schedule;
import com.util.DatabaseUtil;

public class LaboratoryDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String query;
	public ArrayList<Laboratory> getLaboratory(String value)
	{
		 ArrayList<Laboratory> labList = new ArrayList<>();
		 con= DatabaseUtil.getConnection();
		 query = "SELECT LAB_NAME,LAB_ADDRESS,LAB_ZIP_CODE,LAB_STATE,LAB_CITY,TEST_NAME,TEST_CODE,TEST_DESCRIPTION,TOTAL_COST FROM TBL_LABSERVICE_1465039 T1,TEST_LABSERVICE T2 WHERE T1.LAB_ID=T2.LAB_ID AND (LAB_CITY=? OR TEST_NAME= ? OR LAB_NAME= ?)";
		 try {
			ps =con.prepareStatement(query);
			ps.setString(1, value);
			ps.setString(2, value);
			ps.setString(3, value);

			rs= ps.executeQuery();
			while(rs.next())
			{
				String name=rs.getString("LAB_NAME");
				String address = rs.getString("LAB_ADDRESS");
				String zipCode = rs.getString("LAB_ZIP_CODE");
				String state = rs.getString("LAB_STATE");
				String city = rs.getString("LAB_CITY");
				String testName = rs.getString("TEST_NAME");
				String testCode = rs.getString("TEST_CODE");
				String testDes = rs.getString("TEST_DESCRIPTION");
				int cost = rs.getInt("TOTAL_COST");
				Laboratory lab = new Laboratory(name, address, zipCode, state, city, testName, testCode, testDes, cost);
				labList.add(lab);
				System.out.println(labList);

			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return labList;
		 
		
	}
	public ArrayList<Schedule> getSchedule(String labName,String testName)
	{
		 ArrayList<Schedule> secList = new ArrayList<>();
		 String labId;
		 con= DatabaseUtil.getConnection();
		 query = "SELECT LAB_ID FROM TBL_LABSERVICE_1465039 where LAB_NAME=?";
		 try {
			ps =con.prepareStatement(query);
			ps.setString(1, labName);
			rs= ps.executeQuery();
			while(rs.next())
			{
				labId=rs.getString("LAB_ID");
				System.out.println(labId);
				PreparedStatement ps2 = null;
				String query2="SELECT * FROM (SELECT  ST.* FROM TEST_LABSERVICE TL JOIN SCHEDULE ST ON TL.TEST_CODE=ST.TEST_CODE) WHERE LAB_ID=? AND TEST_NAME=?";
				ps2=con.prepareStatement(query2);
				System.out.println(testName);
				ps2.setString(1,labId);
				ps2.setString(2,testName);
				ResultSet rs2 = ps2.executeQuery();
				while(rs2.next())
				{
					String testCode = rs2.getString(2);
					System.out.println(testCode);
					String slots = rs2.getString(4);
					Schedule sc = new Schedule(labId, testCode, testName, slots);
					secList.add(sc);
					System.out.println(secList);
					
				}
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return secList;
		 
		
	}

}
