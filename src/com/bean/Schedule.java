package com.bean;

public class Schedule {
String labId;
String testCode;
String testName;
String slotsAvailaible;
public Schedule(String labId, String testCode, String testName, String slotsAvailaible) {
	super();
	this.labId = labId;
	this.testCode = testCode;
	this.testName = testName;
	this.slotsAvailaible = slotsAvailaible;
}
public Schedule() {
	// TODO Auto-generated constructor stub
}
public String getLabId() {
	return labId;
}
public void setLabId(String labId) {
	this.labId = labId;
}
public String getTestCode() {
	return testCode;
}
public void setTestCode(String testCode) {
	this.testCode = testCode;
}
public String getTestName() {
	return testName;
}
public void setTestName(String testName) {
	this.testName = testName;
}
public String getSlotsAvailaible() {
	return slotsAvailaible;
}
public void setSlotsAvailaible(String slotsAvailaible) {
	this.slotsAvailaible = slotsAvailaible;
}
@Override
public String toString() {
	return "Schedule [labId=" + labId + ", testCode=" + testCode + ", testName=" + testName + ", slotsAvailaible="
			+ slotsAvailaible + "]";
}


}
