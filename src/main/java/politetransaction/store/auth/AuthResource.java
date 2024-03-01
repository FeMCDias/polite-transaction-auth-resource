package politetransaction.store.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
public class AuthResource implements AuthController{

    @Autowired 
    AuthService authService = new AuthService();

    @Override
    public ResponseEntity<?> create(RegisterIn in) {

        final String password = in.password().trim();
        if (null == password || password.isEmpty()) throw new IllegalArgumentException("Password is required");
        if (password.length() < 4) throw new IllegalArgumentException("Password must be at least 4 characters");
        

        final String id = authService.register(Register.builder()
            .name(in.name())
            .email(in.email())
            .password(in.password())
            .build());

        return ResponseEntity.created(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(id)
                .toUri())
            .build();
    }

    @Override
    public ResponseEntity<LoginOut> authenticate(CredentialIn in) {
        authService.authenticate(in.email(), in.password());
        return ResponseEntity.ok(authService.authenticate(in.email(), in.password()));
    }
}

