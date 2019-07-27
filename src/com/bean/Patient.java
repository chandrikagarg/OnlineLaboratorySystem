package com.bean;

public class Patient {
	
	
	public Patient(String firstName, String lastName, String gender, int age, String address,
			long contactNumber, String medicalComplaint, String referredDoctor, String insuranceCover,
			String healthInsuranceNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.contactNumber = contactNumber;
		this.medicalComplaint = medicalComplaint;
		this.referredDoctor = referredDoctor;
		this.InsuranceCover = insuranceCover;
		this.healthInsuranceNo = healthInsuranceNo;
	}


	private String patientId;
	private String firstName;
	private String lastName;
	private String gender;
	private int  age;
	private String address;
	private long contactNumber;
	private String medicalComplaint;
	private String referredDoctor;
	private String InsuranceCover;
	private String healthInsuranceNo ;
	private String question1;
	private String answer1;
	private String question2;
	private String answer2;
	
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
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


	public Patient(String patientId, String firstName, String lastName, String gender, int age, String address,
			long contactNumber, String medicalComplaint) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.contactNumber = contactNumber;
		this.medicalComplaint = medicalComplaint;
	}


	public Patient(String firstName, String lastName, String gender, int age, String address, long contactNumber,
			String medicalComplaint, String referredDoctor, String insuranceCover, String healthInsuranceNo,
			String question1, String answer1, String question2, String answer2) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.contactNumber = contactNumber;
		this.medicalComplaint = medicalComplaint;
		this.referredDoctor = referredDoctor;
		InsuranceCover = insuranceCover;
		this.healthInsuranceNo = healthInsuranceNo;
		this.question1 = question1;
		this.answer1 = answer1;
		this.question2 = question2;
		this.answer2 = answer2;
	}
	
	


	public Patient(String patientId, String firstName, String lastName, String gender, int age, String address,
			long contactNumber, String medicalComplaint, String referredDoctor, String insuranceCover,
			String healthInsuranceNo) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.contactNumber = contactNumber;
		this.medicalComplaint = medicalComplaint;
		this.referredDoctor = referredDoctor;
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

	public String getMedicalComplaint() {
		return medicalComplaint;
	}

	public void setMedicalComplaint(String medicalComplaint) {
		this.medicalComplaint = medicalComplaint;
	}

	public String getReferredDoctor() {
		return referredDoctor;
	}

	public void setReferredDoctor(String referredDoctor) {
		this.referredDoctor = referredDoctor;
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


	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", age=" + age + ", address=" + address + ", contactNumber=" + contactNumber
				+ ", medicalComplaint=" + medicalComplaint + ", referredDoctor=" + referredDoctor + ", InsuranceCover="
				+ InsuranceCover + ", healthInsuranceNo=" + healthInsuranceNo + ", question1=" + question1
				+ ", answer1=" + answer1 + ", question2=" + question2 + ", answer2=" + answer2 + "]";
	}
	
	

}