package com.bean;

public class Laboratory {
	String labId;
	String labName;
	String labAddress;
	String labZipCode;
	String labState;
	String labCity;
	String testName;
	String testCode;
	String testDescription;
	int totalCost;
	public Laboratory(String labName, String labAddress, String labZipCode, String labState, String labCity,
			String testName, String testCode, String testDescription, int totalCost) {
		super();
		this.labName = labName;
		this.labAddress = labAddress;
		this.labZipCode = labZipCode;
		this.labState = labState;
		this.labCity = labCity;
		this.testName = testName;
		this.testCode = testCode;
		this.testDescription = testDescription;
		this.totalCost = totalCost;
	}
	
	public Laboratory() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getLabName() {
		return labName;
	}
	public void setLabName(String labName) {
		this.labName = labName;
	}
	public String getLabAddress() {
		return labAddress;
	}
	public void setLabAddress(String labAddress) {
		this.labAddress = labAddress;
	}
	public String getLabZipCode() {
		return labZipCode;
	}
	public void setLabZipCode(String labZipCode) {
		this.labZipCode = labZipCode;
	}
	public String getLabState() {
		return labState;
	}
	public void setLabState(String labState) {
		this.labState = labState;
	}
	public String getLabCity() {
		return labCity;
	}
	public void setLabCity(String labCity) {
		this.labCity = labCity;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestCode() {
		return testCode;
	}
	
	public String getLabId() {
		return labId;
	}
	public void setLabId(String labId) {
		this.labId = labId;
	}
	public void setTestCode(String testCode) {
		this.testCode = testCode;
	}
	public String getTestDescription() {
		return testDescription;
	}
	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
	public int getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}
	@Override
	public String toString() {
		return "Laboratory [labName=" + labName + ", labAddress=" + labAddress + ", labZipCode=" + labZipCode
				+ ", labState=" + labState + ", labCity=" + labCity + ", testName=" + testName + ", testCode="
				+ testCode + ", testDescription=" + testDescription + ", totalCost=" + totalCost + "]";
	}
	

}
