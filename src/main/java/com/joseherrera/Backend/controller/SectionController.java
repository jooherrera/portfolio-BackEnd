package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.exception.WrongTokenException;
import com.joseherrera.Backend.interfaces.IJwToken;
import com.joseherrera.Backend.interfaces.SectionNames;
import com.joseherrera.Backend.model.SectionTitleModel;
import com.joseherrera.Backend.service.SectionService;
import com.joseherrera.Backend.utils.JwToken;
import com.joseherrera.Backend.utils.Response;
import com.joseherrera.Backend.utils.Token;
import io.jsonwebtoken.SignatureException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/section")
public class SectionController {

    @Value("${jwt.secret.key}")
    String secret;

    @Autowired
    SectionService service;

    @Autowired
    Response response;

    @GetMapping("/{sectionName}")
    public ResponseEntity<SectionTitleModel> get(@PathVariable String sectionName) {

        try {
            SectionTitleModel sectionInfo;
            switch (sectionName) {
                case "about":
                    sectionInfo = service.getOneById(SectionNames.ABOUT.ordinal() + 1);
                    break;
                case "experience":
                    sectionInfo = service.getOneById(SectionNames.EXPERIENCE.ordinal() + 1);
                    break;
                case "curso":
                    sectionInfo = service.getOneById(SectionNames.CURSO.ordinal() + 1);
                    break;
                case "education":
                    sectionInfo = service.getOneById(SectionNames.EDUCATION.ordinal() + 1);
                    break;
                case "hard-skill":
                    sectionInfo = service.getOneById(SectionNames.HSKILL.ordinal() + 1);
                    break;
                case "soft-skill":
                    sectionInfo = service.getOneById(SectionNames.SSKILL.ordinal() + 1);
                    break;
                case "project":
                    sectionInfo = service.getOneById(SectionNames.PROJECT.ordinal() + 1);
                    break;
                default:
                    throw new AssertionError("No existe esa seccion");
            }

            return new ResponseEntity(sectionInfo, HttpStatus.ACCEPTED);

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

            SectionTitleModel modelUpdated ;
            
            switch (sectionName) {
                case "about":
                    service.update(SectionNames.ABOUT.ordinal() + 1, field);
                    modelUpdated = service.getOneById(SectionNames.ABOUT.ordinal() + 1);
                    break;
                case "experience":
                    service.update(SectionNames.EXPERIENCE.ordinal() + 1, field);
                     modelUpdated = service.getOneById(SectionNames.EXPERIENCE.ordinal() + 1);
                    break;
                case "curso":
                    service.update(SectionNames.CURSO.ordinal() + 1, field);
                     modelUpdated = service.getOneById(SectionNames.CURSO.ordinal() + 1);
                    break;
                case "education":
                    service.update(SectionNames.EDUCATION.ordinal() + 1, field);
                     modelUpdated = service.getOneById(SectionNames.EDUCATION.ordinal() + 1);
                    break;
                case "hard-skill":
                    service.update(SectionNames.HSKILL.ordinal() + 1, field);
                     modelUpdated = service.getOneById(SectionNames.HSKILL.ordinal() + 1);
                    break;
                case "soft-skill":
                    service.update(SectionNames.SSKILL.ordinal() + 1, field);
                     modelUpdated = service.getOneById(SectionNames.SSKILL.ordinal() + 1);
                    break;
                case "project":
                    service.update(SectionNames.PROJECT.ordinal() + 1, field);
                     modelUpdated = service.getOneById(SectionNames.PROJECT.ordinal() + 1);
                    break;
                default:
                    throw new AssertionError("No existe esa seccion");
            }

            return new ResponseEntity<>(modelUpdated, HttpStatus.ACCEPTED);
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
