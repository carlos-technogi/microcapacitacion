package com.microsip.synch;

/**
 * Technogi 2016. Todos los derechos reservados
 * Created by carlos_technogi on 3/17/17.
 */
public class GetResponse {

  private String[] content;
  private Integer totalPages;
  private Boolean last;
  private Integer totalElements;
  private Integer size;
  private Integer number;

  public String[] getContent() {
    return content;
  }

  public void setContent(String[] content) {
    this.content = content;
  }

  public Integer getTotalPages() {
    return totalPages;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public Boolean getLast() {
    return last;
  }

  public void setLast(Boolean last) {
    this.last = last;
  }

  public Integer getTotalElements() {
    return totalElements;
  }

  public void setTotalElements(Integer totalElements) {
    this.totalElements = totalElements;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Integer getNumberOfElements() {
    return numberOfElements;
  }

  public void setNumberOfElements(Integer numberOfElements) {
    this.numberOfElements = numberOfElements;
  }

  public Boolean getFirst() {
    return first;
  }

  public void setFirst(Boolean first) {
    this.first = first;
  }

  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
    this.sort = sort;
  }

  private Integer numberOfElements;
  private Boolean first;
  private String sort;
}
