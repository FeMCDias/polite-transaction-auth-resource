package politetransaction.store.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import politetransaction.store.account.AccountController;
import politetransaction.store.account.AccountIn;
import politetransaction.store.account.AccountOut;
import politetransaction.store.account.LoginIn;

@Service
public class AuthService {
    
    @Autowired
    private AccountController accountController;

    @Autowired
    private JwtService jwtService;

    public String register(Register register) {
        
        return accountController.create(AccountIn.builder()
            .name(register.name())
            .email(register.email())
            .password(register.password())
            .build()).getBody().id();
    }

    public LoginOut authenticate(String email, String password) {
        ResponseEntity<AccountOut> response = accountController.login(LoginIn.builder()
            .email(email)
            .password(password)
            .build());
    if (response.getStatusCode().isError())throw new IllegalArgumentException("Invalid credentials");
    if (null == response.getBody().id()) throw new IllegalArgumentException("Invalid credentials");
    
    final AccountOut account = response.getBody();

    // Cria um token JWT
    final String token = jwtService.create(account.id(), account.name(), "regular");
    
    return LoginOut.builder()
        .token(token)
        .build();
    }
}
