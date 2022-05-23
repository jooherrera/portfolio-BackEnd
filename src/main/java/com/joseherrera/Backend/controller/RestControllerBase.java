package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.exception.WrongTokenException;
import com.joseherrera.Backend.interfaces.IJwToken;
import com.joseherrera.Backend.interfaces.IModel;
import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.service.PatchService;
import com.joseherrera.Backend.utils.JwToken;
import com.joseherrera.Backend.utils.Response;
import com.joseherrera.Backend.utils.Token;
import io.jsonwebtoken.SignatureException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

public class RestControllerBase<T extends IModel> {

    @Value("${jwt.secret.key}")
    String secret;

    @Autowired
    IService<T> controllerService;

   // @Autowired
   // PatchService<T> patchService;

    @Autowired
    Response response;

    @GetMapping("/")
    public ResponseEntity<Object> get(@RequestParam int dni) {
        T model = controllerService.get(dni);
        return new ResponseEntity<>(response.successWithObject("Info", model), HttpStatus.ACCEPTED);
    }

    @PatchMapping("/")
    public ResponseEntity<Object> update(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Object> field) {
        try {
            IJwToken jwToken = new JwToken(secret);
            Token token = jwToken.getTokenPayload(authHeader);

            T storedModel = controllerService.get(token.getPersonPK());

            for (String key : field.keySet()) {
                storedModel.updateAttribute(key, field.get(key));
            }

            controllerService.update(storedModel);
            return new ResponseEntity<>(response.success("Actualizado correctamente"), HttpStatus.ACCEPTED);
        } catch (AssertionError e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (WrongTokenException e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.UNAUTHORIZED);
        } catch (SignatureException e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }
}
