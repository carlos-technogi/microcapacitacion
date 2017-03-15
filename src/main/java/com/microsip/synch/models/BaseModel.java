package com.microsip.synch.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Technogi 2016. Todos los derechos reservados
 * Created by carlos_technogi on 3/15/17.
 */
public abstract class BaseModel {

  @Id
  protected String id;

  @NotNull
  protected Long clientId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }

  @CreatedDate
  private Date createdOn;

  @LastModifiedDate
  private Date modifiedOn;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BaseModel baseModel = (BaseModel) o;

    if (id != null ? !id.equals(baseModel.id) : baseModel.id != null) return false;
    return clientId != null ? clientId.equals(baseModel.clientId) : baseModel.clientId == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
    return result;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }

  public Date getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(Date modifiedOn) {
    this.modifiedOn = modifiedOn;
  }
}
