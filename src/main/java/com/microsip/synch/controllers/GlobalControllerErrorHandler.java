package com.microsip.synch.controllers;

import com.microsip.synch.controllers.dto.ErrorMsg;
import com.microsip.synch.exceptions.InvalidRequestException;
import com.microsip.synch.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.io.IOException;

/**
 * Technogi 2016. Todos los derechos reservados
 * Created by carlos_technogi on 3/13/17.
 */
@ControllerAdvice
public class GlobalControllerErrorHandler {

  @ExceptionHandler(InvalidRequestException.class)
  @ResponseStatus(HttpStatus.CONFLICT)
  public void handleInvalidId(InvalidRequestException i, HttpServletResponse res) throws IOException {
    res.getOutputStream().println("jkjkjk");
  }

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public @ResponseBody ErrorMsg handleInvalidId(NotFoundException i, HttpServletResponse res) throws IOException {
    return new ErrorMsg("No se encontró");
  }

  @ExceptionHandler(ConstraintViolationException.class)
  @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
  public @ResponseBody ErrorMsg handleInvalidId(ConstraintViolationException i, HttpServletResponse res) throws IOException {
    return new ErrorMsg("No se encontró");
  }

}
