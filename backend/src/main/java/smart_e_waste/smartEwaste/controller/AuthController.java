package smart_e_waste.smartEwaste.controller;

import smart_e_waste.smartEwaste.dto.*;
import smart_e_waste.smartEwaste.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService auth;
    private final UserService userService;

    public AuthController(AuthService auth, UserService userService) {
        this.auth = auth;
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        return ResponseEntity.ok(auth.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        String token = auth.login(req);
        if (token == null) return ResponseEntity.status(401).body("Invalid credentials");
        return ResponseEntity.ok(token);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUser(@RequestParam String email) {
        return ResponseEntity.ok(userService.getUser(email));
    }
}
