package com.cst323.cloud.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cst323.cloud.Business.PetsBusinessInterface;
import com.cst323.cloud.Components.AppRunner;
import com.cst323.cloud.Data.PetsDataService;
import com.cst323.cloud.Data.Entity.PetsEntity;
import com.cst323.cloud.Data.Repository.PetsRepository;
import com.cst323.cloud.Models.PetModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/backend")
public class PetBackendController {
    // backend will display a list view of pets with options to delete or update
    // their records
    // there will also be a button to create a new pet
    // Update and delete will have separate views that will look similar, delete
    // will have a warning prompt
    // all redirect back to the maintenance page when completed

    @Autowired
    private PetsBusinessInterface petsBusinessInterface;
    private AppRunner app;
    @Autowired
    private PetsRepository repository;

    @Autowired
    private PetsDataService data;

    @GetMapping("/")
    public String display(Model model) {
        petsBusinessInterface.test();

        List<PetModel> pets = petsBusinessInterface.getPets(); // type petModel

        model.addAttribute("message", "Test message and attributes");
        model.addAttribute("pets", pets);
        return "backend";
    }

    @GetMapping("/new")
    public String createPet(Model model) {
        model.addAttribute("title", "Create Form");
        PetsEntity pet = new PetsEntity();
        model.addAttribute("petModel", pet);
        System.out.println("Pet name from getter: " + pet.getPetName());
        return "new";
    }

    @PostMapping("/new")
    public String submitCreatePet(PetModel petModel, BindingResult bindingResult, Model model, Principal principal) {
        // TODO: process POST request
        System.out.println("Posting new pet from create form");

        PetsEntity entity = data.convertFromModel(petModel);
        Boolean check = false;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("PetModel: " + petModel.petName + ", " + petModel.petDesc);
        if (bindingResult.hasErrors()) {
            System.out.println("Validation errors");
            return "new";
        }
        if (petModel.petName == "" || petModel.petName == null) {
            return "new";
        }
        if (petModel.petName != "" || petModel.petName != null) {
            check = data.create(entity);
        }
        if (check) {
            return "redirect:/backend/";
        }
        return "new";
    }

    @GetMapping("/delete/{id}")
    public String deletePet(@PathVariable("id") Long id) {
        data.delete(id);
        return "redirect:/backend/";
    }

    @GetMapping("/update/{id}")
    public String updatePet(@PathVariable("id") Long id, Model model) {
        PetModel pet = data.findById(id);
        System.out.println("Pet id is: " + pet.getId());
        model.addAttribute("title", "Update");
        model.addAttribute("petModel", pet);
        return "update";
    }

    @PostMapping("/update")
    public String updatePetPost(PetModel pet, BindingResult bindingResult, Model model) {
        //PetsEntity entity = data.convertFromModel(pet);
        System.out.println("Update pet id: " + pet.getId());
        System.out.println("Pet: " + pet);
        PetsEntity entity = data.convertFromModel(pet);
        System.out.println("Entity id is: " + entity.getId());
        data.update(entity);
        return "redirect:/backend/";
    }
    
    

}
