package com.service;

import java.util.ArrayList;

import com.bean.Laboratory;
import com.bean.Schedule;
import com.dao.LaboratoryDao;

public class LaboratoryService {
	LaboratoryDao dao = new LaboratoryDao();
	Schedule sch = new Schedule();
	public ArrayList<Laboratory> getLaboratory(String value)
	{
		return dao.getLaboratory(value);
	}
	public ArrayList<Schedule> getSchedule(String labName,String testName)
	{
		return dao.getSchedule(labName, testName);
	}

}
