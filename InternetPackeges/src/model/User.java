/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author user
 */
public class User {
    
   private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final StringProperty adress = new SimpleStringProperty(this, "adress");
    private final StringProperty speed = new SimpleStringProperty(this,"speed");  
    private final StringProperty flow = new SimpleStringProperty(this,"flow");  
    private final StringProperty contract = new SimpleStringProperty(this,"contract");  

    public User() {
    }

    public User(String firstName, String lastName, String adress,String speed,String flow,String contract) {
        
        this.firstName.set(firstName);
	this.lastName.set(lastName);
	this.adress.set(adress);
        this.speed.set(speed);
	this.flow.set(flow);
	this.contract.set(contract);
    }
    
    public User(String firstName){
    
        this.firstName.set(firstName);
    }
    
    public User(String firstName,String lastName){
    
        this.firstName.set(lastName);
        this.lastName.set(lastName);
    
    }
    
    public String getFirstName(){
    
        return firstName.get();
    }
    
   public void setFirstName(String firstName)
    {
	this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty()
    {
	return firstName;
    }

    public String getLastName()
    {
	return lastName.get();
    }

    public void setLastName(String lastName)
    {
	this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty()
    {
	return lastName;
    }
    
    public String getAdress(){
    
        return adress.get();
    }
    
    public void setAdress(String adress){
    
        this.adress.set(adress);
    }
    
    public StringProperty adressProperty(){
    
        return adress;
    }
    
    public String getSpeed(){
    
        return speed.get();
    }
    
    public void setSpeed(String speed){
    
        this.speed.set(speed);
    }
    
    public StringProperty speedProperty(){
    
        return speed;
    }
    
    public String getFlow(){
    
        return flow.get();
    }
   
    public void setFlow(String flow){
    
        this.flow.set(flow);
    }
    
    public StringProperty flowProperty(){
    
        return flow;
    }
    
    public String getContract(){
    
        return contract.get();
    }
    
    public void setContract(String contract){
    
        this.contract.set(contract);
    }
    
    public StringProperty contractProperty(){
    
        return contract;
    }
     private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<>(this, "errorList", new ArrayList<>());

    public ObjectProperty<ArrayList<String>> errorsProperty()
    {
	return errorList;
    }

    public boolean isValid()
    {
	boolean isValid = true;
	if(firstName.get() != null && firstName.get().equals(""))
	{
	    errorList.getValue().add("First name can't be empty!");
	    isValid = false;
	}
	if(lastName.get().equals(""))
	{
	    errorList.getValue().add("Last name can't be empty!");
	    isValid = false;
	}
	if(adress.get().equals(""))
	{
	    errorList.getValue().add("Adress can't be empty!");
	    isValid = false;
	}
        if(speed.get().equals(""))
	{
	    errorList.getValue().add("Speed can't be empty!");
	    isValid = false;
	}
        if(flow.get().equals(""))
	{
	    errorList.getValue().add("Flow can't be empty!");
	    isValid = false;
	}
        if(contract.get().equals(""))
	{
	    errorList.getValue().add("Contract can't be empty!");
	    isValid = false;
	}
	return isValid;
    }
}


