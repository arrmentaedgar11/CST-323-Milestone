package com.gcu.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.Repository.WarrantiesRepository;
import com.gcu.models.ClaimsModel;
import com.gcu.models.WarrantyModel;
import jakarta.validation.Valid;

@Controller
@PreAuthorize("hasRole('ADMIN')")
public class ManagementController {
	
	@Autowired
    private WarrantiesRepository warrantiesRepository;

    @Autowired
	private WarrantiesService warrantiesService;

	@Autowired
	private ClaimsService claimsService;

    @GetMapping("/management")
    public String displayWarranties(Model model) {
        List<ClaimsModel> claims = claimsService.getAllClaims();
        List<WarrantyModel> warranties = warrantiesService.getAllWarranties();
        model.addAttribute("title", "Management Form");
        model.addAttribute("warranties", warranties);
        model.addAttribute("claims", claims);
        return "management";
    }
    
    @GetMapping("/editWarranty/{id}")
    public String editWarranty(@PathVariable("id") int id, Model model) {
        WarrantyModel warranty = warrantiesService.getWarrantyById(id);
        if (warranty == null) {
            // Handle the case where the warranty is not found
            model.addAttribute("error", "Warranty not found");
            return "errorPage";  // Redirect to an error page if necessary
        }
        model.addAttribute("warrantyModel", warranty);
        model.addAttribute("title", "Edit Warranty");
        return "editWarranty";
    }
    
    //POST
    @PostMapping("/management/editWarranty")
    public String editWarrantyString(@Valid @ModelAttribute("warrantyModel") WarrantyModel warrantyModel, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Edit Warranty");
            return "editWarranty";
        }
        warrantiesRepository.save(warrantyModel);
        return "redirect:/management";
    }

    @GetMapping("/editClaimBusiness/{id}")
    public String editClaimBusiness(@PathVariable("id") Long id, Model model) {
    	ClaimsModel claim = claimsService.getClaimById(id);
    	model.addAttribute("title", "Edit Claims (Business)");
    	model.addAttribute("claimsModel", claim);
    	return "editClaimBusiness";
    }
    
  
    @PostMapping("/management/editClaimBusiness")
    public String updateClaimBusiness(@Valid @ModelAttribute ClaimsModel claimsModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Log errors
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println("Error: " + error.getDefaultMessage());
            });
            model.addAttribute("title", "Edit Claims (Business)");
            return "editClaimBusiness";
        }
        claimsService.updateClaim(claimsModel);
        return "redirect:/management";
    }  

    @GetMapping("/createWarranty")
    public String createWarranty(Model model) {
        model.addAttribute("title", "Create Warranty Form");
        model.addAttribute("warrantyModel", new WarrantyModel());
        return "createWarranty";
    }
    
    @PostMapping("/addNewWarranty")
    public String addNewWarranty(@Valid @ModelAttribute WarrantyModel warrantyModel, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Create Warranty Form");
            return "createWarranty";
        }
        warrantiesRepository.save(warrantyModel);
        return "redirect:/management";
    }
    
}
