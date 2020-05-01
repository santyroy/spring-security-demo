package org.roy.unsecureapp.config;

import org.roy.unsecureapp.db.UserRepository;
import org.roy.unsecureapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // get user from DB
        User user = userRepository.findByUsername(s);

        // convert to UserDetails (UserPrincipal)
        UserPrincipal userPrincipal = new UserPrincipal(user);

        // return UserPrincipal
        return userPrincipal;
    }
}
