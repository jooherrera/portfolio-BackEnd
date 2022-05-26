package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.exception.WrongTokenException;
import com.joseherrera.Backend.interfaces.IJwToken;
import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.interfaces.SectionNames;
import com.joseherrera.Backend.model.AboutModel;
import com.joseherrera.Backend.model.SectionModel;
import com.joseherrera.Backend.service.SectionService;
import com.joseherrera.Backend.utils.JwToken;
import com.joseherrera.Backend.utils.Response;
import com.joseherrera.Backend.utils.Token;
import io.jsonwebtoken.SignatureException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/section")
public class SectionController {

    @Value("${jwt.secret.key}")
    String secret;

    @Autowired
    SectionService service;

    @Autowired
    Response response;

    @GetMapping("/{sectionName}")
    public ResponseEntity<SectionModel> get(@PathVariable String sectionName) {

        try {
            switch (sectionName) {
                case "about":
                    SectionModel sectionInfo = service.getOneById(SectionNames.ABOUT.ordinal() + 1);
                    return new ResponseEntity(sectionInfo, HttpStatus.ACCEPTED);
                default:
                    throw new AssertionError("No existe esa seccion");
            }

        } catch (AssertionError e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @PatchMapping("/{sectionName}")
    public ResponseEntity<Object> update(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Object> field, @PathVariable String sectionName) throws Exception {
        try {
            IJwToken jwToken = new JwToken(secret);
            Token token = jwToken.getTokenPayload(authHeader);

            if (!token.getIsAdmin()) {
                throw new WrongTokenException("No estas autorizado a modificar");
            }

            switch (sectionName) {
                case "about":
                    service.update(SectionNames.ABOUT.ordinal() + 1, field);
                    break;
                default:
                    throw new AssertionError("No existe esa seccion");
            }

            return new ResponseEntity<>(response.success("Actualizado correctamente"), HttpStatus.ACCEPTED);
        } catch (AssertionError e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (WrongTokenException e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.UNAUTHORIZED);
        } catch (SignatureException e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

}
