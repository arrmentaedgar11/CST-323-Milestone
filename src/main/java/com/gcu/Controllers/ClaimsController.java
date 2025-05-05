package com.gcu.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.Repository.ClaimsRepository;
import com.gcu.models.ClaimsModel;

import jakarta.validation.Valid;

@Controller
public class ClaimsController {
      
	@Autowired
    private ClaimsRepository claimsRepository;
	
	@Autowired
	private ClaimsService claimsService;
    
    @GetMapping("/claims")
    public String displayWarranties(Model model) {
    	List<ClaimsModel> claims = claimsService.getAllClaims();
        model.addAttribute("title", "Claims Form");
        model.addAttribute("claims", claims);
        return "claims";
    }
    
    //TO:DO
    @PostMapping("/editClaims")
    public void editWarrantyString(@Valid ClaimsModel claimsModel, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Edit Claim Form");
        }
    }

    @GetMapping("/createClaim")
    public String createWarranty(Model model) {
        model.addAttribute("title", "Create Claims Form");
        model.addAttribute("claimsModel", new ClaimsModel());
        return "createClaim";
    }
    
    @PostMapping("/addNewClaim")
    public String addNewWarranty(@Valid @ModelAttribute ClaimsModel claimsModel, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Create Claims Form");
            return "createClaim";
        }
        claimsModel.setClaimStatus("Pending"); //default status
        claimsModel.setClaimActive(true); //default active status
        claimsRepository.save(claimsModel);//stores in DB
        return "redirect:/claims";
    }
}




