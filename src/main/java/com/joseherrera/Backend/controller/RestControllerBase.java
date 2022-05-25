package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.exception.WrongTokenException;
import com.joseherrera.Backend.interfaces.IJwToken;
import com.joseherrera.Backend.interfaces.IModel;
import com.joseherrera.Backend.interfaces.IService;
import com.joseherrera.Backend.utils.JwToken;
import com.joseherrera.Backend.utils.Response;
import com.joseherrera.Backend.utils.Token;
import io.jsonwebtoken.SignatureException;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public class RestControllerBase<T extends IModel> {

    @Value("${jwt.secret.key}")
    String secret;

    @Autowired
    IService<T> controllerService;

    @Autowired
    Response response;

    /*
      @GetMapping("/all/{id}")
    public ResponseEntity<Object> getAll(@PathVariable int id) {
        List<T> model = controllerService.getAllByForeignKeyId(id);
        return new ResponseEntity<>(response.successWithObject("Info", model), HttpStatus.ACCEPTED);
    }
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> get(@PathVariable int id) {
        T model = controllerService.getByPrincipalKey(id);
        return new ResponseEntity<>(response.successWithObject("Info", model), HttpStatus.ACCEPTED);
    }

    /*
    //Utiliza el dni para actualizar las tablas.
    @PatchMapping("/")
    public ResponseEntity<Object> updateSection(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Object> field) {
        try {
            IJwToken jwToken = new JwToken(secret);
            Token token = jwToken.getTokenPayload(authHeader);

            T storedModel = controllerService.getOneByForeignKeyId(token.getPersonPK());

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

     */

    //Usa el ID del registro
    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Object> field, @PathVariable int id) throws Exception {
        try {
            IJwToken jwToken = new JwToken(secret);
            Token token = jwToken.getTokenPayload(authHeader);

            T storedModel = controllerService.getByPrincipalKey(id);

            if (Objects.isNull(storedModel)) {
                throw new Exception("No se encontro el item para actualizar");
            }

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
        } catch (Exception e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        } 

    }

    @PostMapping("/")
    public ResponseEntity<Object> add(@RequestHeader(value = "Authorization", required = false) String authHeader, @RequestBody Map<String, Integer> field) {
        try {
            IJwToken jwToken = new JwToken(secret);
            Token token = jwToken.getTokenPayload(authHeader);

            controllerService.add(field.get("referenceId"));

            return new ResponseEntity<>(response.success("Agregado con exito"), HttpStatus.CREATED);

        } catch (WrongTokenException e) {
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.UNAUTHORIZED);
        }catch(UnsupportedOperationException e){
            return new ResponseEntity<>(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@RequestHeader(value = "Authorization", required = false) String authHeader, @PathVariable int id) {
        try {
            IJwToken jwToken = new JwToken(secret);
            Token token = jwToken.getTokenPayload(authHeader);

            controllerService.delete(id);

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
