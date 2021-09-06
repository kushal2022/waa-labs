package com.example.testdemo.errorHandler;

import com.example.testdemo.response.ErrorResponse;
import org.springframework.stereotype.Repository;

@Repository
public class ErrorHandleService {
    public ErrorResponse error(String message, int statusCode, Object object)
    {
        ErrorResponse errorResponse = new ErrorResponse(message,object,statusCode);
        return errorResponse;
    }


}
