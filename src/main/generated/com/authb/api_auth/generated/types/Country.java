package com.authb.api_auth.generated.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

public class Country {
  private String id;

  private String name;

  private List<Province> provinces;

  public Country() {
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

  public List<Province> getProvinces() {
    return provinces;
  }

  public void setProvinces(List<Province> provinces) {
    this.provinces = provinces;
  }

  @Override
  public String toString() {
    return "Country{id='" + id + "', name='" + name + "', provinces='" + provinces + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Country that = (Country) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(name, that.name) &&
        Objects.equals(provinces, that.provinces);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, provinces);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String name;

    private List<Province> provinces;

    public Country build() {
      Country result = new Country();
      result.id = this.id;
      result.name = this.name;
      result.provinces = this.provinces;
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

    public Builder provinces(List<Province> provinces) {
      this.provinces = provinces;
      return this;
    }
  }
}
