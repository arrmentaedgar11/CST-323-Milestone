package com.gcu.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    
	//displays all claims
    @GetMapping("/claims")
    public String displayWarranties(Model model) {
    	List<ClaimsModel> claims = claimsService.getAllClaims();
        model.addAttribute("title", "Claims Form");
        model.addAttribute("claims", claims);
        return "claims";
    }
    
    //show edit form with pre-populated data
    @GetMapping("/claims/edit/{id}")
    public String editClaim(@PathVariable("id") Long id, Model model) {
    	ClaimsModel claim = claimsService.getClaimById(id);
    	if (claim == null) {
    		//handles claims not found
    		return "redirect:claims";
    	}
    	model.addAttribute("title", "Edit Claim");
    	model.addAttribute("claimsModel", claim);
    	return "editClaim";
    }
    
    //handles for submission for adding new claim
    @PostMapping("/claims/edit")
    public String updateClaim(@Valid @ModelAttribute ClaimsModel claimsModel, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Edit Claim Form");
            return "editClaim";
        }
        claimsService.updateClaim(claimsModel);
        return "redirect:/claims";
    }

    //creates new claim
    @GetMapping("/createClaim")
    public String createWarranty(Model model) {
        model.addAttribute("title", "Create Claims Form");
        model.addAttribute("claimsModel", new ClaimsModel());
        return "createClaim";
    }
    
    //Handles HTTP get request
    @GetMapping("/claims/add")
    public String showCreateClaimForm(Model model) {
    	model.addAttribute("claimsModel", new ClaimsModel());
    	return "createClaim";
    }

    //handles form submission for adding new claim
    @PostMapping("/claims/add")
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
    
    //Handles claim deletions
    @GetMapping("/claims/delete/{id}")
    public String deleteWarranty(@PathVariable("id") Long id) {
    	claimsService.deleteClaim(id);
    	return "redirect:/claims";
    }
}




