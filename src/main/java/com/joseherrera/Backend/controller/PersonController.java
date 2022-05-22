package com.joseherrera.Backend.controller;

import com.joseherrera.Backend.interfaces.IPersonService;
import com.joseherrera.Backend.model.PersonModel;
import com.joseherrera.Backend.utils.Response;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    IPersonService personService;

    @Autowired
    Response response;

    @PatchMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable int id, @RequestBody Map<String, Object> field) {
        try {
            
            PersonModel storedPersonInfo = personService.getPerson(id);
            
            for(String key : field.keySet()){
                
                storedPersonInfo.updateAttribute(key, field.get(key));
            }
            
            
            
            System.out.println(storedPersonInfo.toString());
            personService.updatePerson(storedPersonInfo);
            return new ResponseEntity(response.success("Actualizado correctamente"), HttpStatus.ACCEPTED);
        } catch (AssertionError e) {
            return new ResponseEntity(response.error(e.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (NullPointerException e){
            return new ResponseEntity(response.error("No existe ese campo en el modelo"), HttpStatus.BAD_REQUEST);
        }
    }

}
