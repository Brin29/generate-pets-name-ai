package brien.pets_name.services;

import brien.pets_name.models.AuthResponse;
import brien.pets_name.models.RegisterRequest;
import brien.pets_name.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService{

    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;


    public AuthResponse register(RegisterRequest request){

    }
}
