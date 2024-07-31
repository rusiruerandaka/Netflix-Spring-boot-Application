package com.projectnetflix.netflix.Service;


import com.projectnetflix.netflix.Model.AuthUser;
import com.projectnetflix.netflix.Model.Guser;
import com.projectnetflix.netflix.Repository.AuthGuserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {

    private final AuthGuserRepo authGuserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthUser> authUser = authGuserRepo.findByGusername(username.toLowerCase());
        if(!authUser.isPresent()){
            throw new UsernameNotFoundException(username);

        } else{
            return User.builder()
                    .username(authUser.get().getUsername())
                    .password(authUser.get().getPassword())
                    .disabled(!authUser.get().isActive())
                    .build();
        }

    }



}
