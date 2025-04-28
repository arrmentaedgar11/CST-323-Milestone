package com.gcu.Controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.models.ClaimsModel;
import com.gcu.models.WarrantyModel;
import jakarta.validation.Valid;

@Controller
public class ManagementController {
    List<WarrantyModel> warranties = new ArrayList<WarrantyModel>();
    List<ClaimsModel> claims = new ArrayList<ClaimsModel>();

    @GetMapping("/management")
    public String displayWarranties(Model model) {
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
    public String addNewWarranty(@Valid WarrantyModel warrantyModel, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("title", "Create Warranty Form");
            return "createWarranty";
        }
        warranties.add(warrantyModel);
        return "redirect:/management";
    }
    
}
