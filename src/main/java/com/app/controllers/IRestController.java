package com.app.controllers;

import org.springframework.http.HttpStatus;

import java.util.Map;

/**
 * Created by phitien on 8/12/16.
 */
public interface IRestController {
    IRestController setSuccess();

    IRestController setSuccess(HttpStatus status);

    IRestController setFailure();

    IRestController setFailure(HttpStatus status);

    Map<String, Object> getResponse();

    IRestController put(String K, Object V);
}
