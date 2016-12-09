package com.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by phitien on 8/12/16.
 */
public class AbstractRestController implements IRestController {
    Map<String, Object> response = new HashMap<String, Object>();
    HttpStatus httpStatus = HttpStatus.OK;

    @Override
    public IRestController setSuccess() {
        return setSuccess(HttpStatus.OK);
    }

    @Override
    public IRestController setSuccess(HttpStatus status) {
        response.put("success", true);
        httpStatus = status;
        return this;
    }

    @Override
    public IRestController setFailure() {
        return setFailure(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public IRestController setFailure(HttpStatus status) {
        response.put("success", false);
        httpStatus = status;
        return this;
    }

    @Override
    public Map<String, Object> getResponse() {
        return response;
    }

    public void setResponse(Map<String, Object> response) {
        this.response = response;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public IRestController put(String K, Object V) {
        response.put(K, V);
        return this;
    }

    @ExceptionHandler(Exception.class)
    public Map<String, Object> errorResponse(Exception e, HttpServletResponse response) {
        put("message", e.getMessage());
        Map<String, Object> json = setFailure().getResponse();
        response.setStatus(getHttpStatus().value());
        return json;
    }
}

