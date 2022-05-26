package com.joseherrera.Backend.interfaces;

import java.util.Map;

public interface IResponse {

    public Map<String, String> success(String msg);

    public Map<String, Object> successWithToken(String msg, String token);

    public Map<String, Object> successWithObject(Object payload);

    public Map<String, String> error(String msg);
}
