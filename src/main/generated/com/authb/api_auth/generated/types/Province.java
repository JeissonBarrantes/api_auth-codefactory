package com.authb.api_auth.generated.types;

import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;

public class Province {
  private String id;

  private String name;

  private Country country;

  private List<City> cities;

  public Province() {
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

  public Country getCountry() {
    return country;
  }

  public void setCountry(Country country) {
    this.country = country;
  }

  public List<City> getCities() {
    return cities;
  }

  public void setCities(List<City> cities) {
    this.cities = cities;
  }

  @Override
  public String toString() {
    return "Province{id='" + id + "', name='" + name + "', country='" + country + "', cities='" + cities + "'}";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Province that = (Province) o;
    return Objects.equals(id, that.id) &&
        Objects.equals(name, that.name) &&
        Objects.equals(country, that.country) &&
        Objects.equals(cities, that.cities);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, country, cities);
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {
    private String id;

    private String name;

    private Country country;

    private List<City> cities;

    public Province build() {
      Province result = new Province();
      result.id = this.id;
      result.name = this.name;
      result.country = this.country;
      result.cities = this.cities;
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

    public Builder country(Country country) {
      this.country = country;
      return this;
    }

    public Builder cities(List<City> cities) {
      this.cities = cities;
      return this;
    }
  }
}
