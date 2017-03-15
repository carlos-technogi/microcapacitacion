package com.microsip.synch.models;

import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Language;

import javax.validation.constraints.NotNull;
import java.util.Set;

/**
 * Technogi 2016. Todos los derechos reservados
 * Created by carlos_technogi on 3/13/17.
 */
@Document(collection = "grupos_de_linea")
@CompoundIndexes({
    @CompoundIndex(name = "client_idx_idx", def = "{'clientId': 1, 'name': -1}")
})
public class GrupodeLinea extends BaseModel{



  @Field("name")
  @Indexed
  @Length(min = 4, max = 25)
  @NotNull
  private String name;


  @DBRef
  private Set<Linea> lineas;

  public GrupodeLinea() {
  }

  public GrupodeLinea(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "GrupodeLinea{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GrupodeLinea that = (GrupodeLinea) o;

    if (id != null ? !id.equals(that.id) : that.id != null) return false;
    return name != null ? name.equals(that.name) : that.name == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  public Set<Linea> getLineas() {
    return lineas;
  }

  public void setLineas(Set<Linea> lineas) {
    this.lineas = lineas;
  }

  public Long getClientId() {
    return clientId;
  }

  public void setClientId(Long clientId) {
    this.clientId = clientId;
  }
}
