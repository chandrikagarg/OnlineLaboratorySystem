package com.service;

import java.util.ArrayList;

import com.bean.HealthCareProvider;
import com.bean.Patient;
import com.dao.HcpDao;
import com.dao.ViewPatientFromHcp;

public class HcpService {
	HcpDao dao = new HcpDao();
	public boolean registerHcp(HealthCareProvider h)
	{
		return dao.registerHcp(h);
	}
	
	
	public String matchQuestionAndGetPassword(String hcpId,String question1,String answer1,String question2,String answer2)
	{
		return dao.matchQuestionAndGetPassword(hcpId, question1, answer1, question2, answer2);
	}
	

	public boolean loginAsHCP(String userName,String password)
	{
		
		return dao.loginAsHCP(userName, password);
	}
	public HealthCareProvider hcp(String id2)
	{
		return dao.hcp(id2);
	}
	public boolean updateHcp(HealthCareProvider h){
	
		return dao.updateHcp(h);
	}
	public Patient SearchPatient(String value) {
		return dao.SearchPatient(value);
	}
	
	
	

	public boolean changePasswordHcp(String id,String currentPassword,String newPassword)
	{
		
		
		return dao.changePasswordHcp(id, currentPassword, newPassword);
	}
	
	
	
	

	public ArrayList<Patient> viewPatient(String id)
	{
		ViewPatientFromHcp dd=new ViewPatientFromHcp();
		
		return dd.viewPatient(id);	
	}
	
	
}
