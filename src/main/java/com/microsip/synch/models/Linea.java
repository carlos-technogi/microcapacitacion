package com.microsip.synch.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Null;

/**
 * Technogi 2016. Todos los derechos reservados
 * Created by carlos_technogi on 3/14/17.
 */
@Document
public class Linea {

  @Id
  @Null
  private String id;
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
