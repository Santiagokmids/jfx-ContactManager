package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import model.Contact;
import model.ContactManager;

public class ContactsGUI {

	@FXML
    private BorderPane mainPane;

    @FXML
    private TextField name;

    @FXML
    private TextField email;

    @FXML
    private Label mess;
    
    @FXML
    private TableView<Contact> viewTable;
    
    @FXML
    private TableColumn<Contact, String> number;

    @FXML
    private TableColumn<Contact, String> names;

    @FXML
    private TableColumn<Contact, String> emails;
    
    private ContactManager contactManager;
    
    public ContactsGUI(ContactManager contactM) {
    	contactManager = contactM;
    }
	
	public void initialize() {
    	//the method (initialize) is called several times by diferents fxml file loads 
    }
	
	private void initializeTableView() {
		ObservableList<Contact> observableList;
		observableList = FXCollections.observableArrayList(contactManager.getContacts());
		
		viewTable.setItems(observableList);
		names.setCellValueFactory(new PropertyValueFactory<Contact, String>("name"));
		emails.setCellValueFactory(new PropertyValueFactory<Contact, String>("email"));
	}
	
	@FXML
	public void loadAddContact(ActionEvent event)throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Add.fxml"));
		loader.setController(this);
		
		Parent addContactPane = loader.load();
		
		mainPane.getChildren().clear();
		mainPane.setTop(addContactPane);;
	}
	
	@FXML
	public void loadContactList(ActionEvent event) throws IOException{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("List.fxml"));
		
		loader.setController(this);
		Parent contactList = loader.load();
		
		mainPane.getChildren().clear();
		mainPane.setCenter(contactList);
		initializeTableView();
	}
	
	@FXML
	public void addContact(ActionEvent event) {
		
		if(!name.getText().equals("") && !email.getText().equals("")) {
			contactManager.addContact(name.getText(), email.getText());
			
			name.setText("");
			email.setText("");
			
			mess.setText("The contact has been added succesfully");
		}else
			mess.setText("Enter the data");
	}
	
	  @FXML
	  public void exportContacts(ActionEvent event) {

	    }

	  @FXML
	  public void importContacts(ActionEvent event) {

	    }

}
