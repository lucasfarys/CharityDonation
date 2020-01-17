package pl.coderslab.charity.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.dto.EditUserDTO;
import pl.coderslab.charity.dto.UserDTO;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.model.Uuid;
import pl.coderslab.charity.repository.RoleRepository;
import pl.coderslab.charity.repository.UserRepository;
import pl.coderslab.charity.repository.UuidRepository;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;
    private EmailService emailService;
    private UuidRepository uuidRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       RoleRepository roleRepository, EmailService emailService, UuidRepository uuidRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.emailService = emailService;
        this.uuidRepository = uuidRepository;
    }
    public UserDTO findByUserName(String username) {
        ModelMapper modelMapper = new ModelMapper();
        User user =  userRepository.findByEmail(username);
        user.getRoles().size();
        UserDTO userDTO = modelMapper.map(user,UserDTO.class);
        return userDTO;
    }
    public void registerUser(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO,User.class);
        String digest = createUuid();
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setUuid(digest);
        Role role = roleRepository.findByName("ROLE_USER");
        role.getUsers().add(user);
        user.getRoles().add(role);
        user.setActive(false);
        userRepository.save(user);
        emailService.sendActivationEmail(digest, userDTO.getEmail());

    }
    public void editUser(EditUserDTO editUserDTO){
        UserDTO userDTO = findByUserName(editUserDTO.getEmail());
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userDTO,User.class);
        user.setName(editUserDTO.getName());
        user.setSurname(editUserDTO.getSurname());
        user.setEmail(editUserDTO.getEmail());
        user.setPassword(editUserDTO.getNewPassword());
        user.setActive(editUserDTO.getActive());
        user.setPassword(passwordEncoder.encode(editUserDTO.getNewPassword()));
        userRepository.save(user);
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
    public List<User> findUsersByRole(String userName){
        Role role = roleRepository.findByName(userName);
        List<User> admins = userRepository.findAllByRolesIn(Arrays.asList(role));
        admins.forEach(a->a.getRoles().size());
        return admins;
    }
    public void deleteUser(String email){
        userRepository.deleteAllByEmail(email);
    }
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    public String bytesToHex (byte[] digest){
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < digest.length; i++)
            hexString.append(String.format("%02X", 0xFF & digest[i]));
        return hexString.toString();
    }
    public Boolean activationAccount(String uuid){
        User user = userRepository.findAllByUuid(uuid);
        if(uuid.equals(user.getUuid())){
            user.setActive(true);
            userRepository.save(user);
            return true;
        }else{
            return false;
        }
    }
    public String createUuid (){
        String digest ="";
        try {
            MessageDigest salt = MessageDigest.getInstance("SHA-256");
            salt.update(UUID.randomUUID().toString().getBytes("UTF-8"));
            digest = bytesToHex(salt.digest());
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return digest;
    }
    public void sendRestorePasswordEmailAndSaveUuid(String email){
        Uuid uuid = new Uuid();
        uuid.setUuid(createUuid());
        uuid.setDateTime(LocalDateTime.now());
        uuid.setUser(userRepository.findByEmail(email));
        uuidRepository.save(uuid);
        String subject = "Reset password";
        String message = "http://localhost:8080/user/newPassword/" + uuid.getUuid();
        emailService.sendSimpleMessage(email,subject,message);
    }
    public Long countByUuidList(String uuid){
        return uuidRepository.countAllByUuid(uuid);
    }
    public void changePassword(String passsword, String uuid){
        Uuid uuidObject = uuidRepository.findAllByUuid(uuid);
        User user =  userRepository.findAllByUuidListIn(uuidObject);
        user.setPassword(passwordEncoder.encode(passsword));
        userRepository.save(user);
    }
}
