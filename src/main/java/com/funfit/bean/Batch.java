package com.funfit.bean;

public class Batch {
	private int batch_id;
	private String type_of_batch;
	private String time;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}
	public String getType_of_batch() {
		return type_of_batch;
	}
	public void setType_of_batch(String type_of_batch) {
		this.type_of_batch = type_of_batch;
	}
	
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Batch(int batch_id, String type_of_batch, String time) {
		super();
		this.batch_id = batch_id;
		this.type_of_batch = type_of_batch;
		this.time = time;
	}
	@Override
	public String toString() {
		return "Batch [batch_id=" + batch_id + ", type_of_batch=" + type_of_batch + ", time=" + time + "]";
	}

}