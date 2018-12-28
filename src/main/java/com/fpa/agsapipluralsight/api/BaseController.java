package com.fpa.agsapipluralsight.api;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.server.ResponseStatusException;


public abstract class BaseController {

    public ResponseStatusException handleException(HttpStatus status,
                                                   @Nullable String message,
                                                   @Nullable Throwable ex){
        return new ResponseStatusException(status, message, ex);
    }

}
