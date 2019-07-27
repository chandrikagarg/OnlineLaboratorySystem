package com.bean;

public class Dependent {
	private String patientId;
	private String firstName;
	private String lastName;
	private String relationShip;
	private String gender;
	private int  age;
	private String address;
	private long contactNumber;
	private String InsuranceCover;
	private String healthInsuranceNo ;
	public Dependent() {
		super();
		
	}
	public Dependent(String firstName, String lastName, String relationShip, String gender, int age, String address,
			long contactNumber, String insuranceCover, String healthInsuranceNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.relationShip = relationShip;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.contactNumber = contactNumber;
		InsuranceCover = insuranceCover;
		this.healthInsuranceNo = healthInsuranceNo;
	}
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRelationShip() {
		return relationShip;
	}
	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getInsuranceCover() {
		return InsuranceCover;
	}
	public void setInsuranceCover(String insuranceCover) {
		InsuranceCover = insuranceCover;
	}
	public String getHealthInsuranceNo() {
		return healthInsuranceNo;
	}
	public void setHealthInsuranceNo(String healthInsuranceNo) {
		this.healthInsuranceNo = healthInsuranceNo;
	}
	
	

}
