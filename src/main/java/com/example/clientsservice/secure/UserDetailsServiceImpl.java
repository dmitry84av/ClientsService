package com.example.clientsservice.secure;

import com.example.clientsservice.models.User;
import com.example.clientsservice.repositiries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    //@Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        System.err.println(user);
        if (user == null)
            throw new UsernameNotFoundException(username);
        return new UserDetailImpl(user);
    }
}
