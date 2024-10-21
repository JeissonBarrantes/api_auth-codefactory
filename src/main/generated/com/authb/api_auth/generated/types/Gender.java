package com.authb.api_auth.generated.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

public class Gender {
  private String id;

  private String name;

  private List<User> users;

  public Gender() {
  }

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

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "Gender{id='" + id + "', name='" + name + "', users='" + users + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Gender that = (Gender) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(name, that.name) &&
        Objects.equals(users, that.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, users);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String name;

    private List<User> users;

    public Gender build() {
      Gender result = new Gender();
      result.id = this.id;
      result.name = this.name;
      result.users = this.users;
      return result;
    }

    public Builder id(String id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder users(List<User> users) {
      this.users = users;
      return this;
    }
  }
}
