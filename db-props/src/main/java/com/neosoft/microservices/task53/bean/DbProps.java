package com.neosoft.microservices.task53.bean;

public class DbProps {

	private String driver_class_name;
	private String url;
	private String username;
	private String password;

	

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String pass) {
		this.password = pass;
	}

	public DbProps() {
		super();
	}

	public String getDriver_class_name() {
		return driver_class_name;
	}

	public void setDriver_class_name(String driver_class_name) {
		this.driver_class_name = driver_class_name;
	}

	public DbProps(String driver_class_name, String url, String username, String pass) {
		super();
		this.driver_class_name = driver_class_name;
		this.url = url;
		this.username = username;
		this.password = pass;
	}
	
}
