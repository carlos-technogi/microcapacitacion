package com.microsip.synch.controllers.dto;

/**
 * Technogi 2016. Todos los derechos reservados
 * Created by carlos_technogi on 3/13/17.
 */
public class ErrorMsg {
  String msg;

  public ErrorMsg() {
  }

  public ErrorMsg(String msg) {
    this.msg = msg;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
