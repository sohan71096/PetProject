package com.cg.pa.bean;

public class PetBean 
{
	private String ownerName;
	private String ownerPhNo;
	private String ownerAge;
	private String vaccineDate;
	private String petType;
	private String ownerId;
	
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerPhNo() {
		return ownerPhNo;
	}
	public void setOwnerPhNo(String string) {
		this.ownerPhNo = string;
	}
	public String getOwnerAge() {
		return ownerAge;
	}
	public void setOwnerAge(String string) {
		this.ownerAge = string;
	}
	public String getVaccineDate() {
		return vaccineDate;
	}
	public void setVaccineDate(String vaccineDate) {
		this.vaccineDate = vaccineDate;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	@Override
	public String toString() {
		return "ownerId= " + ownerId + "ownerName= " + ownerName + ", ownerPhNo= " + ownerPhNo + ", ownerAge= " + ownerAge
				+ ", vaccineDate= " + vaccineDate ;
	}
	
	
	
}
