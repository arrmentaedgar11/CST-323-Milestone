package main.java.com.gcu.Controllers;
//Created by Alethea Morton
//This controller handles registration requests and forms

import main.java.com.gcu.models.UserModel;

@Controller
@RequestMapping("/register")
public class RegisterUserController {

    @GetMapping("/") // full mapping is /request/
    public String display(Model model){
        model.addAttribute("title", "Registration Form");
        model.addAttribute("loginModel", new UserModel());
        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(UserModel userModel, BindingResult bindingResult, Model model){
        System.out.println(String.format("Form: User with Username of %s and Password of %s created", userModel.getUsername(), userModel.getPassword()));
        //Figure out how to add the new user to the list of existing users and later the database
        return "/";
    }
}
