package com.joseherrera.Backend.service;

import com.joseherrera.Backend.exception.WrongTokenException;
import com.joseherrera.Backend.interfaces.IJwToken;
import com.joseherrera.Backend.interfaces.IModel;
import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.utils.JwToken;
import com.joseherrera.Backend.utils.Response;
import com.joseherrera.Backend.utils.Token;
import io.jsonwebtoken.SignatureException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PatchService<T extends IModel> {

    /*
    
    
    @Value("${jwt.secret.key}")
    String secret;

    @Autowired
    Response response;
    

    public ResponseEntity<Object> start(String authHeader, Map<String, Object> field, IService<T> service ) {
        try {
            IJwToken jwToken = new JwToken(secret);
            Token token = jwToken.getTokenPayload(authHeader);
            //int id = isPersonModel ? token.getPrimaryKey() : token.getPersonPK();
            
            T storedModel = service.getByPrincipalKey(1);
            
            for(String key : field.keySet()){
                storedModel.updateAttribute(key, field.get(key));
            }
            
            service.update(storedModel);
            return new ResponseEntity<>(response.success("Actualizado correctamente"), HttpStatus.ACCEPTED);
         } catch (AssertionError e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (WrongTokenException e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.UNAUTHORIZED);
        } catch (SignatureException e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
    */
    
}
