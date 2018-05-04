import java.util.Date;

public class Account {
/** private properties **/
private int id;
private double balance;
private double annualInterestRate;
private Date dateCreated;

/** Constructors **/
//Default no-arg constructor
Account(){
  id = 0;
  balance = 0;
  annualInterestRate = 0;
  dateCreated = new Date();
}

//Account constructor with specified id and initial balance
Account(int id_, double balance_){
  id = id_;
  balance = balance_;
  dateCreated = new Date();
}

/** Mutator Methods **/
//set id
public void setId(int id_){
  id = id_;
}

//set balance
public void setBalance(double balance_){
  balance = balance_;
}

//set annualInterestRate
public void setAnnualInterestRate(double annualInterestRate_){
  annualInterestRate = annualInterestRate_;
}

/** Accessor Methods **/
//get Id
public int getId(){
  return id;
}

//get balance
public double getBalance(){
  return balance;
}

//get annualInterestRate
public double getAnnualInterestRate(){
  return annualInterestRate;
}

//get date created
public String getDateCreated() {
  return dateCreated.toString();
}

/** Methods **/
//method to return monthly interest rate
public double getMonthlyInterestRate(){
  return annualInterestRate / 12;
}

//method to return monthly interest accrued
public double getMonthylInterest(){
  return balance * (getAnnualInterestRate() / 100);
}

//method to withdraw that reflects the change on the balance
public void withdraw(double amount){
  balance -= amount;
}

//method to deposit that reflects the change on the balance
public void deposit(double amount){
  balance += amount;
}

//toString method outputs account information
public String toString(){
  return "\nAccount ID: " + id
    + "\nDate Created: " + getDateCreated()
    + "\nBalance: $" + String.format("%.2f", balance)
    + "\nMonthly Interest: $" + String.format("%.2f", getMonthylInterest());
}

// convertToString method to convert double variables to strings that are formatted to 2 decimal spaces
public String convertToString(double amount_){
  return String.format("%.2f", amount_);
}
}