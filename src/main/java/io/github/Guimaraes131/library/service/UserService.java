package io.github.Guimaraes131.library.service;

import io.github.Guimaraes131.library.model.User;
import io.github.Guimaraes131.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User register(OAuth2User principal) {
        var optionalUser = userRepository.findByEmail(principal.getAttributes().get("email").toString());

        if(optionalUser.isEmpty()){
            return userRepository.save(new User(principal));
        }

        return optionalUser.get();

    }
}
