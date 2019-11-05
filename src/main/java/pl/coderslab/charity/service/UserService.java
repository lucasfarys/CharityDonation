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
    public User findByUserName(String username) {
        return userRepository.findByEmail(username);
    }
    public void registerUser(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO,User.class);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }
    public void registerEditUser(EditUserDTO editUserDTO){
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(editUserDTO,User.class);
        user.setPassword(passwordEncoder.encode(editUserDTO.getNewPassword()));
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
    public boolean isPasswordCorrect(EditUserDTO editUserDTO){
        User user = userRepository.findByEmail(SecurityContextHolder.getContext().
                getAuthentication().getName());
        System.out.println(user.getPassword());
        if(passwordEncoder.matches(user.getPassword(),editUserDTO.getOldPassword())){
            return true;
        }else{
            return false;
        }
    }
}
