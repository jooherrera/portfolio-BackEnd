package com.joseherrera.Backend.utils;

import com.joseherrera.Backend.interfaces.IResponse;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class Response implements IResponse {

    @Override
    public Map<String, String> success(String msg) {
        Map<String, String> json = new HashMap<>();
        json.put("Success", msg);
        return json;
    }

    @Override
    public Map<String, String> error(String msg) {
        Map<String, String> json = new HashMap<>();
        json.put("Error", msg);
        return json;
    }

    @Override
    public Map<String, String> successWithToken(String msg, String token) {
        Map<String, String> json = new HashMap<>();
        json.put("Success", msg);
        json.put("Token", token);
        return json;
    }
    

    @Override
    public Map<String, Object> successWithObject(String msg, Object payload) {
        Map<String, Object> json = new HashMap<>();
        json.put("Success", msg);
        json.put("Payload", payload);
        return json;
    }
    
    

}
