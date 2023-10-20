package dev.simpleapp.twitter.security.usecase;

import dev.simpleapp.twitter.security.web.model.RegisterRequest;

//Interface for registration new users
public interface RegisterUserAccountUseCase {
    void register(RegisterRequest registerRequest);
}
