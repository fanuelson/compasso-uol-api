package com.compasso.uol.exceptions.handlers;

import com.compasso.uol.exceptions.ApiException;
import com.compasso.uol.exceptions.vo.ConstraintErrorModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    protected ResponseEntity<Object> handleConflict(ApiException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), ex.getStatus(), request);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraint(ConstraintViolationException ex) {
        return ResponseEntity.badRequest().body(
                ex.getConstraintViolations().stream().map((constraintViolation -> {

                    String message = constraintViolation.getMessage();
                    String field = constraintViolation.getPropertyPath().toString();
                    return new ConstraintErrorModel(constraintViolation.getMessage(),
                            constraintViolation.getMessage(), String.format("%s: %s", message, field));
                })).collect(Collectors.toList())
        );
    }
}
