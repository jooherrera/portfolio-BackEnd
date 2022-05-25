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
        json.put("success", msg);
        return json;
    }

    @Override
    public Map<String, String> error(String msg) {
        Map<String, String> json = new HashMap<>();
        json.put("error", msg);
        return json;
    }

    @Override
    public Map<String, Object> successWithToken(String msg, String token) {
        Map<String, Object> json = new HashMap<>();
        json.put("message", msg);
        json.put("token", token);
        json.put("success", true);
        return json;
    }
    

    @Override
    public Map<String, Object> successWithObject(String msg, Object payload) {
        Map<String, Object> json = new HashMap<>();
        json.put("success", msg);
        json.put("payload", payload);
        return json;
    }
    
    

}
