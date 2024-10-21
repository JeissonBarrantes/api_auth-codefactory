package com.authb.api_auth.generated.types;

import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class User {
  private Integer id;

  private IdType idType;

  private City city;

  private Gender gender;

  private Role role;

  private String identificationNumber;

  private String firstName;

  private String lastName;

  private String birthDate;

  private String phoneNumber;

  private String email;

  private String password;

  private String avatarUrl;

  private String address;

  public User() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public IdType getIdType() {
    return idType;
  }

  public void setIdType(IdType idType) {
    this.idType = idType;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  public String getIdentificationNumber() {
    return identificationNumber;
  }

  public void setIdentificationNumber(String identificationNumber) {
    this.identificationNumber = identificationNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(String birthDate) {
    this.birthDate = birthDate;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "User{id='" + id + "', idType='" + idType + "', city='" + city + "', gender='" + gender + "', role='" + role + "', identificationNumber='" + identificationNumber + "', firstName='" + firstName + "', lastName='" + lastName + "', birthDate='" + birthDate + "', phoneNumber='" + phoneNumber + "', email='" + email + "', password='" + password + "', avatarUrl='" + avatarUrl + "', address='" + address + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    User that = (User) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(idType, that.idType) &&
        Objects.equals(city, that.city) &&
        Objects.equals(gender, that.gender) &&
        Objects.equals(role, that.role) &&
        Objects.equals(identificationNumber, that.identificationNumber) &&
        Objects.equals(firstName, that.firstName) &&
        Objects.equals(lastName, that.lastName) &&
        Objects.equals(birthDate, that.birthDate) &&
        Objects.equals(phoneNumber, that.phoneNumber) &&
        Objects.equals(email, that.email) &&
        Objects.equals(password, that.password) &&
        Objects.equals(avatarUrl, that.avatarUrl) &&
        Objects.equals(address, that.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, idType, city, gender, role, identificationNumber, firstName, lastName, birthDate, phoneNumber, email, password, avatarUrl, address);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private Integer id;

    private IdType idType;

    private City city;

    private Gender gender;

    private Role role;

    private String identificationNumber;

    private String firstName;

    private String lastName;

    private String birthDate;

    private String phoneNumber;

    private String email;

    private String password;

    private String avatarUrl;

    private String address;

    public User build() {
      User result = new User();
      result.id = this.id;
      result.idType = this.idType;
      result.city = this.city;
      result.gender = this.gender;
      result.role = this.role;
      result.identificationNumber = this.identificationNumber;
      result.firstName = this.firstName;
      result.lastName = this.lastName;
      result.birthDate = this.birthDate;
      result.phoneNumber = this.phoneNumber;
      result.email = this.email;
      result.password = this.password;
      result.avatarUrl = this.avatarUrl;
      result.address = this.address;
      return result;
    }

    public Builder id(Integer id) {
      this.id = id;
      return this;
    }

    public Builder idType(IdType idType) {
      this.idType = idType;
      return this;
    }

    public Builder city(City city) {
      this.city = city;
      return this;
    }

    public Builder gender(Gender gender) {
      this.gender = gender;
      return this;
    }

    public Builder role(Role role) {
      this.role = role;
      return this;
    }

    public Builder identificationNumber(String identificationNumber) {
      this.identificationNumber = identificationNumber;
      return this;
    }

    public Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }

    public Builder birthDate(String birthDate) {
      this.birthDate = birthDate;
      return this;
    }

    public Builder phoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }

    public Builder avatarUrl(String avatarUrl) {
      this.avatarUrl = avatarUrl;
      return this;
    }

    public Builder address(String address) {
      this.address = address;
      return this;
    }
  }
}
