package model;

public class Contact {
	
	private String name;
	private String email;
	
	public Contact(String names, String emails) {
		name = names;
		email = emails;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
