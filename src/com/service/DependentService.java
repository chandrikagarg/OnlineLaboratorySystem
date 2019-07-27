package com.service;

import com.bean.Dependent;
import com.dao.DependentDao;

public class DependentService {
	DependentDao dao = new DependentDao();
	
	public boolean addDependent(Dependent d)
	{
		return dao.addDependent(d);
	}
	
}
