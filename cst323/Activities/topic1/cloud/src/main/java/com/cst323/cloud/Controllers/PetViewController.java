package com.cst323.cloud.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cst323.cloud.Business.PetsBusinessInterface;
import com.cst323.cloud.Components.AppRunner;
import com.cst323.cloud.Models.PetModel;

//Pet View Controller will handle displaying a grid view of the available pets, as well as the individual pet pages


@Controller
@RequestMapping("/adopt")
public class PetViewController {

    @Autowired
    private PetsBusinessInterface petsBusinessInterface;
    private AppRunner app;

    @GetMapping("/")
    public String display(Model model) {
        petsBusinessInterface.test();

        List<PetModel> pets = petsBusinessInterface.getPets(); //type petModel

        model.addAttribute("message", "Test message and attributes");
        model.addAttribute("pets", pets);
        return "adopt";
    }
    
    @GetMapping("/{id}")
    public String viewPet(@PathVariable("id") Long id, Model model) {
        PetModel pet = petsBusinessInterface.getPetById(id);
        System.out.println("Pet found: " + pet.petName);
        model.addAttribute("title", "View pet");
        model.addAttribute("petModel", pet);
        return "display";
    }
    
    
}
