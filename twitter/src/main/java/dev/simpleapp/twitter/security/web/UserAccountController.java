package dev.simpleapp.twitter.security.web;

import dev.simpleapp.twitter.security.mapper.RegisterRequestToUserAccountMapper;
import dev.simpleapp.twitter.security.model.UserAccount;
import dev.simpleapp.twitter.security.model.UserRole;
import dev.simpleapp.twitter.security.service.UserAccountService;
import dev.simpleapp.twitter.security.service.UserRoleService;
import dev.simpleapp.twitter.security.web.model.RegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("/api/v1/accounts")
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final RegisterRequestToUserAccountMapper mapper;


    public UserAccountController(UserAccountService userAccountService,
                                 RegisterRequestToUserAccountMapper mapper) {
        this.userAccountService = userAccountService;
        this.mapper = mapper;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("Register request: {}", registerRequest);

        UserAccount userAccount = this.mapper.map(registerRequest);
        this.userAccountService.createUserAccount(userAccount);

    }
}
