package brien.pets_name.services;

import brien.pets_name.models.AuthResponse;
import brien.pets_name.models.LoginRequest;
import brien.pets_name.models.RegisterRequest;

public interface IAuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}