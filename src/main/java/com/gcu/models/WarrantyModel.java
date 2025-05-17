package com.gcu.models;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Table("warranties")//Maps warranties table to DB
public class WarrantyModel {
    @Id
    private int id;
    @Column("warrantyName")
    @NotNull(message="Please enter Warranty Name")
    @Size(min=1, max=32, message="Warranty Name must be between 1 and 32 characters")
    private String warrantyName;
    @Column("warrantyDesc")
    @NotNull(message="Please enter Warranty Description")
    @Size(min=1, max=32, message="Warranty description must be between 1 and 128 characters")
    private String warrantyDesc;
    @Column("productCategory")
    @NotNull(message="Please enter Product Category")
    @Size(min=1, max=32, message="Product Category must be between 1 and 32 characters")
    private String productCategory;
    @Column("restockFees")
    @NotNull(message="Please enter a Restock Fee")
    @PositiveOrZero(message="Please enter a Restock Fee")
    private BigDecimal restockFees;
    @Column("email")
    @NotNull(message="Please enter an email")
    @Email(message="Please enter an email")
    private String email;
    @Column("phoneNumber")
    @PositiveOrZero(message="Please enter a valid phone number.")
    private String phoneNumber;
    @Column("returnInstructions")
    @NotNull
    @Size(min=1, max=128, message="Product Category must be between 1 and 128 characters")
    private String returnInstructions;
    @Column("expirationDate")
    @NotNull
    @PositiveOrZero
    private Integer expirationDate;

    public WarrantyModel(int id, String warrantyName, String warrantyDesc, String productCategory, BigDecimal restockFees, String email,
            String phoneNumber, String returnInstructions, Integer expirationDate) {
        this.id = id;
        this.warrantyName = warrantyName;
        this.warrantyDesc = warrantyDesc;
        this.productCategory = productCategory;
        this.restockFees = restockFees;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.returnInstructions = returnInstructions;
        this.expirationDate = expirationDate;
    }

    public WarrantyModel() {
    }

    public String getWarrantyDesc() {
        return warrantyDesc;
    }
    public void setWarrantyDesc(String warrantyDesc) {
        this.warrantyDesc = warrantyDesc;
    }
    public String getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    public BigDecimal getRestockFees() {
        return restockFees;
    }
    public void setRestockFees(BigDecimal restockFees) {
        this.restockFees = restockFees;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getReturnInstructions() {
        return returnInstructions;
    }
    public void setReturnInstructions(String returnInstructions) {
        this.returnInstructions = returnInstructions;
    }
    public Integer getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Integer expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWarrantyName() {
        return warrantyName;
    }

    public void setWarrantyName(String warrantyName) {
        this.warrantyName = warrantyName;
    }
}
