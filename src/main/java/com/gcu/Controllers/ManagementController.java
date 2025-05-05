package com.gcu.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.Repository.WarrantiesRepository;
import com.gcu.models.ClaimsModel;
import com.gcu.models.WarrantyModel;
import jakarta.validation.Valid;

@Controller
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
    
    //TO:DO 
    @PostMapping("/editWarranty")
    public void editWarrantyString(@Valid WarrantyModel warrantyModel, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Edit Warranty Form");
        }
    }

    //TO:DO
   @PostMapping("/editClaim")
   public void postMethodName(@Valid ClaimsModel claimsModel, BindingResult bindingResult, Model model) {
    if(bindingResult.hasErrors()){
        model.addAttribute("title", "Edit Claims Form");
    }
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
