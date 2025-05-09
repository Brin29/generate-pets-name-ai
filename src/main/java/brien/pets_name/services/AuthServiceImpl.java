package brien.pets_name.services;

import brien.pets_name.jwt.JwtService;
import brien.pets_name.models.AuthResponse;
import brien.pets_name.models.LoginRequest;
import brien.pets_name.models.RegisterRequest;
import brien.pets_name.models.UserModel;
import brien.pets_name.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService{

    private final AuthenticationManager authenticationManager;
    private final UserRepository repository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public AuthResponse register(RegisterRequest request){
        UserModel user = UserModel.builder()
                .username(request.getUsername())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        repository.save(user);

        return AuthResponse
                .builder()
                .token(jwtService.getToken(user))
                .build();
    }

    public AuthResponse login(LoginRequest request){

        // Autenticacion
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserDetails userDetails = repository.findByyUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(userDetails);

        return AuthResponse
                .builder()
                .token(token)
                .build();
    }
}
