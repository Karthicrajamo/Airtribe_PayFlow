package com.assessement.upi_payment.service;

import com.assessement.upi_payment.entity.Users;
import com.assessement.upi_payment.exception.UserNotFoundException;
import com.assessement.upi_payment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users registerUser(Users user){
        Optional<Users> registeredUser = userRepository.findByUpiId(user.getUpiId());

        if(registeredUser.isPresent()){
            throw new RuntimeException("User already exists with this UPI ID");
        }
        return userRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users getUserById(Long id) throws UserNotFoundException{
        return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User not found with this UPI ID"));
    }

    public Users findByUpiId(String upiId) throws RuntimeException{
        return userRepository.findByUpiId(upiId).orElseThrow(()-> new RuntimeException("User not found with this UPI ID"));
    }
}
