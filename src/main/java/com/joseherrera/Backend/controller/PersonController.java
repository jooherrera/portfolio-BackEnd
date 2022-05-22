package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.exception.WrongTokenException;
import com.joseherrera.Backend.interfaces.IContactService;
import com.joseherrera.Backend.interfaces.IJwToken;
import com.joseherrera.Backend.interfaces.IPersonService;
import com.joseherrera.Backend.model.ContactModel;
import com.joseherrera.Backend.model.PersonModel;
import com.joseherrera.Backend.service.ContactService;
import com.joseherrera.Backend.utils.JwToken;
import com.joseherrera.Backend.utils.Response;
import com.joseherrera.Backend.utils.Token;
import io.jsonwebtoken.SignatureException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PersonController {

    @Value("${jwt.secret.key}")
    String secret;

    @Autowired
    IPersonService personService;

    @Autowired
    IContactService contactService;

    @Autowired
    Response response;

    @PatchMapping("/person")
    public ResponseEntity<Object> update(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Object> field) {
        try {

            IJwToken jwToken = new JwToken(secret);
            Token token = jwToken.getTokenPayload(authHeader);
            
            PersonModel storedPersonInfo = personService.getPerson(token.getPrimaryKey());

            for (String key : field.keySet()) {
                storedPersonInfo.updateAttribute(key, field.get(key));
            }

            personService.updatePerson(storedPersonInfo);
            return new ResponseEntity(response.success("Actualizado correctamente"), HttpStatus.ACCEPTED);
        } catch (AssertionError e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (NullPointerException e) {
            return new ResponseEntity(response.error("No existe ese campo en el modelo"), HttpStatus.BAD_REQUEST);
        }catch (WrongTokenException e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.UNAUTHORIZED);
        } catch (SignatureException e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/contact")
    public ResponseEntity<Object> contact(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Object> field) {
        try {

            IJwToken jwToken = new JwToken(secret);
            Token token = jwToken.getTokenPayload(authHeader);

            ContactModel storedContact = contactService.getContact(token.getPersonPK());

            for (String key : field.keySet()) {
                storedContact.updateAttribute(key, field.get(key));
            }

            contactService.updateContact(storedContact);
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
