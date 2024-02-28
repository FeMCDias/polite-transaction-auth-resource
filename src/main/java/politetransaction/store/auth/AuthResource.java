package politetransaction.store.auth;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthResource implements AuthController{

    @Override
    public ResponseEntity<?> create(RegisterIn in) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<LoginOut> authenticate(CredentialIn in) {
        // TODO Auto-generated method stub
        return null;
    }
}

