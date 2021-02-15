package model;

import java.util.List;
import java.util.ArrayList;

public class ContactManager {
	private List<Contact> contacts;
	
	public ContactManager() {
		contacts = new ArrayList<>();
	}	
	
	public List<Contact> getContacts() {
		return contacts;
	}
	
	public void addContact(String name, String email) {
		contacts.add(new Contact(name, email));
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
}
