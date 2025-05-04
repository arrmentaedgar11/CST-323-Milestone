package com.gcu.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

@Table("claims")//Maps claims table to DB
public class ClaimsModel {
	
   
	@Id
	private Long id;
    
	@Column("businessName")
    @NotNull(message="Please enter business name")
    @Size(min=1, max=32, message="Business name must be between 1 and 32 characters")
    private String businessName;
    
    @Column("orderNumber")//makes sure column name matches database column
    @NotNull(message="Please enter a order number")
    @PositiveOrZero(message="Please enter a order number")
    private int orderNumber;
    
    @Column("returnReason")
    @NotNull(message="Please enter a return reason")
    @Size(min=1, max=32, message="Return Reason must be between 1 and 64 characters")
    private String returnReason;
    
    @Column("claimStatus")
    private String claimStatus;
    
    @Column("preferredResolution")
    @NotNull(message="Please select preferred resolution")
    @Size(min=1, max=32, message="Preferred resolution must be between 1 and 32 characters")
    private String preferredResolution;
    
    @Column("businessResponse")
    private String businessResponse;
    @Column("approvedResolutionType")
    private String approvedResolutionType;
    @Column("returnInstructions")
    private String returnInstructions;
    @Column("claimActive")
    private Boolean claimActive;

    //constructors
    public ClaimsModel() {
    }
    
    public ClaimsModel(Long id, String businessName, int orderNumber, String returnReason, String claimStatus,
            String preferredResolution, String businessResponse, String approvedResolutionType,
            String returnInstructions, Boolean claimActive) {
        
        this.id = id;
        this.businessName = businessName;
        this.orderNumber = orderNumber;
        this.returnReason = returnReason;
        this.claimStatus = claimStatus;
        this.preferredResolution = preferredResolution;
        this.businessResponse = businessResponse;
        this.approvedResolutionType = approvedResolutionType;
        this.returnInstructions = returnInstructions;
        this.claimActive = claimActive;
    }

    //getters and setters
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getBusinessName() {
        return businessName;
    }
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }
    public int getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
    public String getReturnReason() {
        return returnReason;
    }
    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }
    public String getClaimStatus() {
        return claimStatus;
    }
    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }
    public String getPreferredResolution() {
        return preferredResolution;
    }
    public void setPreferredResolution(String preferredResolution) {
        this.preferredResolution = preferredResolution;
    }
    public String getBusinessResponse() {
        return businessResponse;
    }
    public void setBusinessResponse(String businessResponse) {
        this.businessResponse = businessResponse;
    }
    public String getApprovedResolutionType() {
        return approvedResolutionType;
    }
    public void setApprovedResolutionType(String approvedResolutionType) {
        this.approvedResolutionType = approvedResolutionType;
    }
    public String getReturnInstructions() {
        return returnInstructions;
    }
    public void setReturnInstructions(String returnInstructions) {
        this.returnInstructions = returnInstructions;
    }
    public Boolean getClaimActive() {
        return claimActive;
    }
    public void setClaimActive(Boolean claimActive) {
        this.claimActive = claimActive;
    }


}