package com.example.homework.data.entity;

import javax.persistence.Entity;

import com.example.homework.data.AbstractEntity;

@Entity
public class Address extends AbstractEntity {

private String street;
public String getStreet() {
  return street;
}
public void setStreet(String street) {
  this.street = street;
}
private String postalCode;
public String getPostalCode() {
  return postalCode;
}
public void setPostalCode(String postalCode) {
  this.postalCode = postalCode;
}
private String city;
public String getCity() {
  return city;
}
public void setCity(String city) {
  this.city = city;
}
private String state;
public String getState() {
  return state;
}
public void setState(String state) {
  this.state = state;
}
private String country;
public String getCountry() {
  return country;
}
public void setCountry(String country) {
  this.country = country;
}



}
