package com.authb.api_auth.generated.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class signInInput {
  private String email;

  private String password;

  public signInInput() {
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

  @Override
  public String toString() {
    return "signInInput{email='" + email + "', password='" + password + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    signInInput that = (signInInput) o;
    return Objects.equals(email, that.email) &&
        Objects.equals(password, that.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String email;

    private String password;

    public signInInput build() {
      signInInput result = new signInInput();
      result.email = this.email;
      result.password = this.password;
      return result;
    }

    public Builder email(String email) {
      this.email = email;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }
  }
}
