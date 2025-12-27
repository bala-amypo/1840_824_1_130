// package com.example.demo.controller;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     @Autowired
//     private UserService userService;

//     @GetMapping("/users")
//     public List<User> getAllUsers() {
//         return userService.getAllUsers();
//     }

//     @GetMapping("/user/{id}")
//     public User getUser(@PathVariable Long id) {
//         User u = userService.getUserById(id);
//         // Fixed getters
//         System.out.println("Email: " + u.getEmail());
//         System.out.println("Roles: " + u.getRoles());
//         return u;
//     }
// }
package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtTokenProvider jwt;

    public AuthController(UserRepository userRepo,
                          PasswordEncoder encoder,
                          JwtTokenProvider jwt) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        if (userRepo.findByEmail(req.getEmail()).isPresent()) {
            return ResponseEntity.status(409).build();
        }

        User u = User.builder()
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .roles(req.getRoles())
                .name(req.getName())
                .build();

        userRepo.save(u);
        String token = jwt.createToken(u.getId(), u.getEmail(), u.getRoles());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest req) {
        Optional<User> u = userRepo.findByEmail(req.getEmail());
        if (u.isEmpty() || !encoder.matches(req.getPassword(), u.get().getPassword())) {
            return ResponseEntity.status(401).build();
        }

        String token = jwt.createToken(
                u.get().getId(),
                u.get().getEmail(),
                u.get().getRoles()
        );
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
