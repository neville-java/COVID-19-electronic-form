/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_controller;

public class Product2 {

    private int ID;
    private String first_name;
    private String surname;
    private String Contact;
     private int Age;
    private String H_Address;
    private String Email;
    private double Temperature;
    String Q1_answer;
    String Q2_answer;

    public Product2() {
    }

    public Product2(int ID, String first_name, String surname,String Contact, int Age,String H_Address,String Email,double Temperature,String Q1,String Q2) {
        this.ID = ID;
        this.first_name = first_name;
        this.surname = surname;
        this.Contact =  Contact;
        this.Age = Age;
        this.H_Address = H_Address;
        this.Email =  Email;
        this.Temperature =  Temperature;
        this.Q1_answer=Q1;
        this.Q2_answer=Q2;
    }
// id
    public  void setID(int id){
    this.ID = id;
}
    public int getID() {
       return ID;
    }
    //name
public void setName(String n){
    this.first_name = n;
}
    public String  getFirstName() {
       return first_name;  
    }
//last name 
   public void setLastname(String n){
    this.surname = n;
}
    public String  getLastName() {
       return surname;  
    }
//dob
    public void setAge(int n){
    this.Age = n;
}
    public int getAge() {
      return Age;
    }
//salary
    public void setAddress(String address){
    this.H_Address = address;
}
    public String getAddress() {
        return  H_Address;
    }
///department
     public void setEmail(String email){
    this.Email = email;
}
     
    public String getEmail() {
      return Email;
    }
//overtime
 public void setTemperature(double temp){
    this.Temperature = temp;
}    
    public double getTemperature() {
        return Temperature;
         }
    public void setContact(String cont){
    this.Contact = cont;
}    
    public String getContact() {
        return Contact;
         }
     public void setQ1(String q1){
    this.Q1_answer = q1;
}    
    public String getQ1() {
        return Q1_answer;
         }
    
     public void setQ2(String q2){
    this.Q2_answer = q2;
}    
    public String getQ2() {
        return Q2_answer;
         }


   

}
