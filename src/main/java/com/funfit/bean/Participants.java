package com.funfit.bean;

public class Participants {
	private int participant_id;
	private String first_name;
	private int age;
	private String phone_number;
	private int batch_id;
	public int getParticipantId() {
		return participant_id;
	}
	public void setParticipantId(int participant_id) {
		this.participant_id = participant_id;
	}
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phone_number;
	}
	public void setPhoneNumber(String phone_number) {
		this.phone_number = phone_number;
	}
	public int getBatchId() {
		return batch_id;
	}
	public void setBatchId(int batch_id) {
		this.batch_id = batch_id;
	}
	public Participants() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Participants(int participant_id, String first_name, int age, String phone_number, int batch_id) {
		super();
		this.participant_id = participant_id;
		this.first_name = first_name;
		this.age = age;
		this.phone_number = phone_number;
		this.batch_id = batch_id;
	}
	@Override
	public String toString() {
		return "Participants [participant_id=" + participant_id + ", first_name=" + first_name + ", age=" + age
				+ ", phone_number=" + phone_number + ", batch_id=" + batch_id + "]";
	}
	
	
}
