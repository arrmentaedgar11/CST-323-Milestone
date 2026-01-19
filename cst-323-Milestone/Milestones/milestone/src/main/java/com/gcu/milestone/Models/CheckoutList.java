package com.gcu.milestone.Models;

import java.util.ArrayList;
import java.util.List;

public class CheckoutList {
            private List<CheckoutModel> Checkouts = new ArrayList<CheckoutModel>();

   //XmlElement(name="Checkout")
    public List<CheckoutModel> getCheckouts(){
        return this.Checkouts;
    }

    public void setCheckouts(List<CheckoutModel> Checkouts){
        this.Checkouts = Checkouts;
    }
}
