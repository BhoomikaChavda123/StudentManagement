package com.example.StudentManagement.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.StudentManagement.Model.User;
import com.example.StudentManagement.Repository.UserRepository;

@Controller
public class SaveUserContreoller {
      
	 @Autowired
	 UserRepository repository;    
	 
	 @GetMapping("/adduser")
	 public String showform(Model model)
	 {
		 model.addAttribute("user", new User());
		 return "adduser";
	 }   

	 @PostMapping("/saveUser")
	 public String saveUser(@ModelAttribute("user") User user, Model model) {
	     Optional<User> existingUser = repository.findByEmail(user.getEmail());

	     // If creating new user and email already exists
	     if (user.getId() == 0 && existingUser.isPresent()) {
	         model.addAttribute("user", user);
	         model.addAttribute("error", "Email already exists.");
	         return "adduser";
	     }

	     // If editing and email is being changed to one that already exists
	     if (user.getId() != 0 && existingUser.isPresent() && existingUser.get().getId() != user.getId()) {
	         model.addAttribute("user", user);
	         model.addAttribute("error", "Email already exists.");
	         return "adduser";
	     }

	    // Set active on save
	     repository.save(user);
	     return "redirect:/showUsers";
	 }

	 
	 // Show all users
	    @GetMapping("/showUsers")
	    public String showUsers(Model model) {
	        List<User> users = repository.findAll(); // <-- Fetch all users from DB
	        model.addAttribute("users", users);          // <-- Add to model
	        return "show";
	    }     
	    
	    @GetMapping("/editUser/{id}")
	    public String editUser(@PathVariable("id") int id, Model model) {
	        User existingUser = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user ID: " + id));
	        model.addAttribute("user", existingUser);
	        return "adduser"; // reuse the same form
	    }     
	    
	    @GetMapping("/deleteUser/{id}")
	    public String deleteUser(@PathVariable("id") Integer id) {
	        repository.deleteById(id);
	        return "redirect:/showUsers";
	    }


}
