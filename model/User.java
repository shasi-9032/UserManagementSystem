package com.mainproject.model;

public class User {
	private int id;
	private String name;
	private long mobile;
	private String city;
	public User(int id, String name, long mobile, String city) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.city = city;
	}
	public User(String name, long mobile, String city) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	

}
