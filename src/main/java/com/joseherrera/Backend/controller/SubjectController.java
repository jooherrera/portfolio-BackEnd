package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.exception.WrongTokenException;
import com.joseherrera.Backend.interfaces.IJwToken;
import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.model.SchoolModel;
import com.joseherrera.Backend.model.SubjectModel;
import com.joseherrera.Backend.service.SubjectService;
import com.joseherrera.Backend.utils.JwToken;
import com.joseherrera.Backend.utils.Response;
import com.joseherrera.Backend.utils.Token;
import io.jsonwebtoken.SignatureException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Primary
@RestController
@CrossOrigin(origins = "*")
@RequestMapping({"/api/v1/curso/school/{schoolId}/subject", "/api/v1/curso/school/subject"})
public class SubjectController {

    @Value("${jwt.secret.key}")
    String secret;

    @Autowired
    SubjectService subjectService;

    @Autowired
    IService<SchoolModel> schoolService;

    @Autowired
    Response response;

    @GetMapping("/")
    @ResponseBody
    public List<SubjectModel> get(@PathVariable Optional<Integer> schoolId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @PostMapping("/")
    public SubjectModel add(@PathVariable Optional<Integer> schoolId) throws Exception {
        if (schoolId.isEmpty()) {
            throw new Exception("No se encontro un ID para agregar");
        }
        return subjectService.addWithId(schoolId.get());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Object> field, @PathVariable int id) {
        try {
            IJwToken jwToken = new JwToken(secret);
            Token token = jwToken.validate(authHeader);

            if (!token.getIsAdmin()) {
                throw new WrongTokenException("No estas autorizado a modificar");
            }

            subjectService.update(id, field);

            SubjectModel updatedModel = subjectService.getOneById(id);

            return new ResponseEntity<>(updatedModel, HttpStatus.ACCEPTED);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@RequestHeader(value = "Authorization", required = false) String authHeader, @PathVariable int id) {
        try {
            IJwToken jwToken = new JwToken(secret);
            jwToken.validate(authHeader);

            subjectService.delete(id);

            return new ResponseEntity<>(response.success("Eliminado correctamente"), HttpStatus.ACCEPTED);
        } catch (AssertionError e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (WrongTokenException e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.UNAUTHORIZED);
        } catch (SignatureException e) {
            return new ResponseEntity(response.error("Token no válido"), HttpStatus.BAD_REQUEST);
        } catch (EmptyResultDataAccessException e) {
            return new ResponseEntity(response.error("No existe el id ingresado"), HttpStatus.BAD_REQUEST);
        }
    }

}
