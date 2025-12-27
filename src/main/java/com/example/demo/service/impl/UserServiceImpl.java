// package com.example.demo.service.impl;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.model.User;
// import com.example.demo.service.UserService;
// import org.springframework.stereotype.Service;

// import java.util.*;

// @Service
// public class UserServiceImpl implements UserService {

//     private Map<Long, User> users = new HashMap<>();

//     @Override
//     public User authenticate(AuthRequest request) {
//         return users.values().stream()
//                 .filter(u -> u.getEmail().equals(request.getEmail()) &&
//                              u.getPassword().equals(request.getPassword()))
//                 .findFirst().orElse(null);
//     }

//     @Override
//     public User getUserById(Long id) {
//         return users.get(id);
//     }

//     @Override
//     public List<User> getAllUsers() {
//         return new ArrayList<>(users.values());
//     }

//     @Override
//     public User updateUser(Long id, User updatedUser) {
//         User u = users.get(id);
//         if (u != null) {
//             u.setName(updatedUser.getName());
//             u.setEmail(updatedUser.getEmail());
//             u.setPassword(updatedUser.getPassword());
//             u.setRoles(updatedUser.getRoles());
//         }
//         return u;
//     }
// }
package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
