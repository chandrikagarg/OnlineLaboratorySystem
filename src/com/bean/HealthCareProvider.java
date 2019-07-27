package com.bean;

public class HealthCareProvider {
private String hcpId;
private String hcpName;
private String licenseNo;
private String address;
private long contactNo;
private long alternateContactNo;
private String emailId;
private String question1;
private String answer1;
private String question2;
private String answer2;
public HealthCareProvider(String hcpId, String hcpName, String licenseNo, String address, long contactNo,
		long alternateContactNo, String emailId) {
	super();
	this.hcpId = hcpId;
	this.hcpName = hcpName;
	this.licenseNo = licenseNo;
	this.address = address;
	this.contactNo = contactNo;
	this.alternateContactNo = alternateContactNo;
	this.emailId = emailId;
}

public HealthCareProvider(String hcpName, String licenseNo, String address, long contactNo, long alternateContactNo,
		String emailId, String question1, String answer1, String question2, String answer2) {
	super();
	this.hcpName = hcpName;
	this.licenseNo = licenseNo;
	this.address = address;
	this.contactNo = contactNo;
	this.alternateContactNo = alternateContactNo;
	this.emailId = emailId;
	this.question1 = question1;
	this.answer1 = answer1;
	this.question2 = question2;
	this.answer2 = answer2;
}

public HealthCareProvider() {
	super();
	// TODO Auto-generated constructor stub
}
public String getHcpId() {
	return hcpId;
}
public void setHcpId(String hcpId) {
	this.hcpId = hcpId;
}
public String getHcpName() {
	return hcpName;
}
public void setHcpName(String hcpName) {
	this.hcpName = hcpName;
}
public String getLicenseNo() {
	return licenseNo;
}
public void setLicenseNo(String licenseNo) {
	this.licenseNo = licenseNo;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getContactNo() {
	return contactNo;
}
public void setContactNo(long contactNo) {
	this.contactNo = contactNo;
}
public long getAlternateContactNo() {
	return alternateContactNo;
}
public void setAlternateContactNo(long alternateContactNo) {
	this.alternateContactNo = alternateContactNo;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}

public String getQuestion1() {
	return question1;
}

public void setQuestion1(String question1) {
	this.question1 = question1;
}

public String getAnswer1() {
	return answer1;
}

public void setAnswer1(String answer1) {
	this.answer1 = answer1;
}

public String getQuestion2() {
	return question2;
}

public void setQuestion2(String question2) {
	this.question2 = question2;
}

public String getAnswer2() {
	return answer2;
}

public void setAnswer2(String answer2) {
	this.answer2 = answer2;
}

@Override
public String toString() {
	return "HealthCareProvider [hcpId=" + hcpId + ", hcpName=" + hcpName + ", licenseNo=" + licenseNo + ", address="
			+ address + ", contactNo=" + contactNo + ", alternateContactNo=" + alternateContactNo + ", emailId="
			+ emailId + "]";
}



}
