package com.mycompany.cosc005w_mock_planeapp;

public class Payment {
    private String email;
    private double paymentAmount;


    // Constructor
    public Payment (String email, double paymentAmount){
        this.email = email;
        this.paymentAmount = paymentAmount;
    }

    //getter
    public String getEmail(){
        return this.email;
    }
    //setter
    public void setEmail(String email){
        this.email = email;
    }
    //getter
    public double getPaymentAmount(){
        return this.paymentAmount;
    }
    //setter
    public void setPaymentAmount(double paymentAmount){
        this.paymentAmount = paymentAmount;
    }
    
    public void printPayment(){
        System.out.println("Email: " + email + ", Payment Amount: $" + paymentAmount);
        
    }
}
