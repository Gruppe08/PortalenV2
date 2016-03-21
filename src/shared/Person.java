package pro.solution.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Person implements IsSerializable  {

	private String username;
	private String password;
	private String urlImage;
	private char sex;
	private String description;
	
	public Person(String username, String password, String urlImage, char sex, String description) {
		this.username = username;
		this.password = password;
		this.urlImage = urlImage;
		this.sex = sex;
		this.description = description;
	}
	
	public Person(){
		
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUrlImage() {
		return urlImage;
	}
	
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	public char getSex() {
		return sex;
	}
	
	public void setSex(char sex) {
		this.sex = sex;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
