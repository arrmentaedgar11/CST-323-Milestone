package com.gcu.milestone.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gcu.milestone.Data.Entities.CheckoutEntity;
import com.gcu.milestone.Data.Entities.MovieEntity;
import com.gcu.milestone.Data.Services.CheckoutDataService;
import com.gcu.milestone.Data.Services.MovieDataService;
import com.gcu.milestone.Data.Services.UserDataService;
import com.gcu.milestone.Models.CheckoutModel;
import com.gcu.milestone.Models.RentalViewModel;
import com.gcu.milestone.Models.UserModel;
import com.gcu.milestone.Models.movieModel;

import jakarta.servlet.http.HttpSession;

@Controller
public class VideoRentalController {

    @Autowired
    private MovieDataService movieService;

    @Autowired
    private UserDataService userService;

    @Autowired
    private CheckoutDataService checkoutService;

    // Redirect root to login
    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    // ===== LOGIN =====

    // Shows the  login page
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }

    // Handles the login form
    @PostMapping("/login")
    public String doLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {

        // Check credentials
        UserModel user = userService.findByUsernameAndPassword(username, password);

        if (user == null) 
        {
            model.addAttribute("loginError", "No user found");
            return "login";
        }

        // Save logged-in user in session
        session.setAttribute("currentUser", user);

        // Go to catalog
        return "redirect:/catalog";
    }
    
    // ===== LOGOUT =====
    @GetMapping("/logout")
    public String logout(HttpSession session) 
    {
        session.invalidate();
        return "redirect:/login";
    }


    // ===== CATALOG =====

    @GetMapping("/catalog")
    public String showCatalog(HttpSession session, Model model) {

        // Require login
        UserModel currentUser = (UserModel) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }
        
        model.addAttribute("currentUser", currentUser);

        // Get all movies
        List<movieModel> movies = movieService.findAll();
        model.addAttribute("movies", movies);

        return "catalog";
    }

    // ===== CHECK OUT MOVIE =====

    
    @PostMapping("/checkout/{id}")
    public String checkoutMovie(@PathVariable("id") Long movieId, HttpSession session) {

        UserModel currentUser = (UserModel) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }

        // Look up movie
        movieModel movie = movieService.findById(movieId);
        if (movie == null) {
            return "redirect:/catalog";
        }

        // Create checkout entry
        CheckoutEntity checkoutEntity = new CheckoutEntity(movie.getId(), currentUser.getId());
        checkoutService.create(checkoutEntity);

        // Update movie status and current user
        movie.setStatus("Checked Out");
        movie.setUserId(currentUser.getId());
        MovieEntity movieEntity = movieService.convertFromModel(movie);
        movieService.update(movieEntity);

        return "redirect:/myrentals";
    }

    // ===== MY RENTALS =====

    @GetMapping("/myrentals")
    public String showMyRentals(HttpSession session, Model model) {

        UserModel currentUser = (UserModel) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }
        
        model.addAttribute("currentUser", currentUser);

        int currentUserId = currentUser.getId();

        List<CheckoutModel> allCheckouts = checkoutService.findAll();
        List<RentalViewModel> rentals = new ArrayList<>();

        // Build list of rentals for this user
        for (CheckoutModel checkout : allCheckouts) {
            if (checkout.getUserId() == currentUserId) {

                movieModel movie = movieService.findById((long) checkout.getMovieId());
                String title = (movie != null) ? movie.getTitle() : "Unknown";

                RentalViewModel viewModel = new RentalViewModel(
                        checkout.getId(),     // rental id
                        title,                 // movie title
                        currentUser.getUsername()); // username

                rentals.add(viewModel);
            }
        }

       
        model.addAttribute("rentals", rentals);

        return "myrentals";
    }

    // ===== RETURN MOVIE =====

    @GetMapping("/return/{id}")
    public String returnMovie(@PathVariable("id") Long checkoutId, HttpSession session) {

        UserModel currentUser = (UserModel) session.getAttribute("currentUser");
        if (currentUser == null) {
            return "redirect:/login";
        }

        // Find checkout record
        CheckoutModel checkout = checkoutService.findById(checkoutId);
        if (checkout == null) {
            return "redirect:/myrentals";
        }

        // Reset movie status
        movieModel movie = movieService.findById((long) checkout.getMovieId());
        if (movie != null) {
            movie.setStatus("Available");
            movie.setUserId(0);
            MovieEntity movieEntity = movieService.convertFromModel(movie);
            movieService.update(movieEntity);
        }

        // Delete checkout record
        checkoutService.delete(checkoutId);

        return "redirect:/myrentals";
    }
}
