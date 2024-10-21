package com.authb.api_auth.generated.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class Token {
  private String token;

  public Token() {
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public String toString() {
    return "Token{token='" + token + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Token that = (Token) o;
    return Objects.equals(token, that.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String token;

    public Token build() {
      Token result = new Token();
      result.token = this.token;
      return result;
    }

    public Builder token(String token) {
      this.token = token;
      return this;
    }
  }
}
