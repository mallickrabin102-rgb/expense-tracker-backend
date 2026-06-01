package com.rabin.demo;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
@RestController
public class AuthController {
    private final UserRepository userRepository;
 private final BCryptPasswordEncoder  passwordEncoder;

    public AuthController (UserRepository userRepository,BCryptPasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/register")
public User register(@RequestBody User user){
   Optional<User> foundUser = userRepository.findByEmail(user.getEmail());
   if (foundUser.isPresent()) {
    throw new RuntimeException ("Email Already Exists");

}
    user.setPassword(passwordEncoder.encode(user.getPassword()));

   return userRepository.save(user);
}
@PostMapping("/login")
public String login(@RequestBody User user){
    Optional<User> foundUser = userRepository.findByEmail(user.getEmail());
    if (!foundUser.isPresent()) {
     throw new RuntimeException("User Not Found!");
    }

 User dbUser = foundUser.get();
    if (passwordEncoder.matches(user.getPassword(),dbUser.getPassword())) {
        return "Login Sucessful";
    }
return "Invalid Password! ";
}

}
