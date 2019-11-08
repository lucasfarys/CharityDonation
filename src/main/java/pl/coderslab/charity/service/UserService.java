package pl.coderslab.charity.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.EditUserDTO;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }
    public UserDTO findByUserName(String username) {
        ModelMapper modelMapper = new ModelMapper();
        User user =  userRepository.findByEmail(username);
        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
        return userDTO;
    }
    public void registerUser(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO,User.class);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
    public void editUser(EditUserDTO editUserDTO){
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(editUserDTO,User.class);
        user.setPassword(passwordEncoder.encode(editUserDTO.getNewPassword()));
    }
    public void editAdmin (UserDTO userDTO){
        User admin = userRepository.findByEmail(userDTO.getEmail());
        admin.setEmail(userDTO.getEmail());
        admin.setName(userDTO.getName());
        admin.setSurname(userDTO.getSurname());
        userRepository.save(admin);
    }
    public boolean isEmailAvailable(String email) {
        long count = userRepository.countByEmail(email);
        if (count > 0) {
            return false;
        }
        else {
            return true;
        }
    }
}
