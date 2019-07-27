package com.service;

import com.dao.ForgotDao;

public class Forgotservice {
	
	
	ForgotDao dao=new ForgotDao();
	public String validate(String id)
	{
		return dao.validate(id);
		
		
	}
	
	public String[] matchQuestionAndGetAnswers(String Id)
	{
		
		
		return dao.matchQuestionAndGetAnswers(Id);
	}
	
	public boolean match(String answer1,String answer2,String[] answers)
	{
		
		
		return dao.match(answer1, answer2, answers);
	}
	
	public boolean forgotpassword(String id,String newpwd)
	{
		return dao.forgotpassword(id, newpwd);
	}
	public String[] matchQuestionAndGetAnswersForHcp(String Id)
	{
		
		return dao.matchQuestionAndGetAnswersForHcp(Id);
	}
	
	public boolean forgotpasswordforHcp(String id,String newpwd)
	{
		
		
		return dao.forgotpasswordforHcp(id, newpwd);
	}
	}


