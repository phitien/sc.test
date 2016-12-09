package com.app.exceptions;

/**
 * Created by phitien on 8/12/16.
 */
public class ProductNotFound extends Exception {
    @Override
    public String getMessage() {
        return "PRODUCT_NOT_FOUND";
    }
}
