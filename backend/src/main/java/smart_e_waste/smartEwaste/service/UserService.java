package smart_e_waste.smartEwaste.service;

import smart_e_waste.smartEwaste.dto.UserDto;
import smart_e_waste.smartEwaste.entity.User;
import smart_e_waste.smartEwaste.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public UserDto getUser(String email) {
        User u = repo.findByEmail(email);
        if (u == null) return null;
        UserDto dto = new UserDto();
        dto.setId(u.getId());
        dto.setEmail(u.getEmail());
        dto.setFullName(u.getFullName());
        return dto;
    }
}
