package smart_e_waste.smartEwaste.service;

import smart_e_waste.smartEwaste.dto.*;
import smart_e_waste.smartEwaste.entity.User;
import smart_e_waste.smartEwaste.repository.UserRepository;
import smart_e_waste.smartEwaste.util.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class AuthService {
    private final UserRepository repo;
    private final JwtUtil jwt;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public AuthService(UserRepository repo, JwtUtil jwt) {
        this.repo = repo;
        this.jwt = jwt;
    }

    public UserDto register(RegisterRequest req) {
        User u = new User();
        u.setEmail(req.getEmail());
        u.setPassword(encoder.encode(req.getPassword()));
        u.setFullName(req.getFullName());
        repo.save(u);

        UserDto dto = new UserDto();
        dto.setId(u.getId());
        dto.setEmail(u.getEmail());
        dto.setFullName(u.getFullName());
        return dto;
    }

    public String login(LoginRequest req) {
        User u = repo.findByEmail(req.getEmail());
        if (u != null && encoder.matches(req.getPassword(), u.getPassword())) {
            return jwt.generateToken(u.getEmail());
        }
        return null;
    }
}
