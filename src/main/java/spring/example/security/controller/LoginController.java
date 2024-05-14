package spring.example.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import spring.example.security.model.User;
import spring.example.security.repository.UserRepo;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class LoginController {
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;
    
    
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        ResponseEntity response=null;
        
        try{
            
            String hashPassword=passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            User savedUser=userRepo.save(user);
            if(savedUser.getId()>0){
                response=ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
            
        }catch (Exception ex){
            response=ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("AN exception occured due to " + ex.getMessage());
            
        }
        return response;
    }
}
