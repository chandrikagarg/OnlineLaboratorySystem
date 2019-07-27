package com.service;



import com.bean.Dependent;
import com.bean.Patient;
import com.dao.Patientdao;

public class PatientService {

	Patientdao dao=new Patientdao();
	
	public String[]  addPatient(Patient p)
	{
		
		return dao.addPatient(p);
	}
	
	

	public boolean changePassword(String id,String currentPassword,String newPassword)
	{
		
		return dao.changePassword(id, currentPassword, newPassword);
	}
	
	public boolean loginAsPatient(String userName,String password)
	{
		
		return dao.loginAsPatient(userName, password);
	}
	
	public Patient viewPatient(String id)
	{
		return dao.viewPatient(id);
	}



	public boolean updatePatientDetails(Patient p1, String pId) {
		
		return dao.updatePatientDetails(p1, pId);
	}
	

	public boolean deletePatient(String id)
	{
		
		return dao.deletePatient(id);
	}



	public boolean addDependentDetails(String userId, Dependent d) {
		return dao.adddependent(userId,d);
	}



	public String[] addPatientByHcp(Patient p, String hcpId) {
		return dao.addPatientByHcp(p, hcpId);
	}

	
	
	
	
}
