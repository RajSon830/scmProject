package com.scm.scm20.services.Impl;

import com.scm.scm20.entities.User;
import com.scm.scm20.helper.ResourceNotFoundException;
import com.scm.scm20.repositories.UserRepo;
import com.scm.scm20.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepo userRepo;

    //private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {

        // user id : have to generate
        String uuid = UUID.randomUUID().toString();
        user.setUserId(uuid);
        // password encode

      return   userRepo.save(user);
    }

    @Override
    public Optional<User> getUserById(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user) {
        User user2 = userRepo.findById(user.getUserId()).orElseThrow(()->new ResourceNotFoundException("Resource Not Found"));

        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhoneNumber(user2.getPhoneNumber());
        user2.setProfilePic(user.getProfilePic());
        user2.setEnable(user.isEnable());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user2.getProviderUserId());
        User save =userRepo.save(user2);
        return Optional.of(save);
    }

    @Override
    public void deleteUser(String id) {
                User user2 =  userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User Not Found! "));
                 userRepo.delete(user2);
    }

    @Override
    public boolean isUserExist(String userId) {
        User user2 = userRepo.findById(userId).orElse(null);
        return user2 != null;
    }

    @Override
    public boolean isUserExistByEmail(String email) {

        User user2= userRepo.findByEmail(email).orElse(null);
        return user2!=null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
