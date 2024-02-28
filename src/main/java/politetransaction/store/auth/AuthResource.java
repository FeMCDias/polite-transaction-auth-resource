package politetransaction.store.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import politetransaction.store.account.AccountController;
import politetransaction.store.auth.CredentialIn;
import politetransaction.store.auth.LoginOut;
import politetransaction.store.auth.RegisterIn;

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

