package com.authb.api_auth.generated;

import java.lang.String;

public class DgsConstants {
  public static final String QUERY_TYPE = "Query";

  public static final String MUTATION_TYPE = "Mutation";

  public static class USER {
    public static final String TYPE_NAME = "User";

    public static final String Id = "id";

    public static final String IdType = "idType";

    public static final String City = "city";

    public static final String Gender = "gender";

    public static final String Role = "role";

    public static final String IdentificationNumber = "identificationNumber";

    public static final String FirstName = "firstName";

    public static final String LastName = "lastName";

    public static final String BirthDate = "birthDate";

    public static final String PhoneNumber = "phoneNumber";

    public static final String Email = "email";

    public static final String Password = "password";

    public static final String AvatarUrl = "avatarUrl";

    public static final String Address = "address";
  }

  public static class TOKEN {
    public static final String TYPE_NAME = "Token";

    public static final String Token = "token";
  }

  public static class QUERY {
    public static final String TYPE_NAME = "Query";

    public static final String UserById = "userById";

    public static final String UserByEmail = "userByEmail";

    public static class USERBYID_INPUT_ARGUMENT {
      public static final String Id = "id";
    }

    public static class USERBYEMAIL_INPUT_ARGUMENT {
      public static final String Email = "email";
    }
  }

  public static class MUTATION {
    public static final String TYPE_NAME = "Mutation";

    public static final String SignUp = "signUp";

    public static final String SignIn = "signIn";

    public static final String ModifyRole = "modifyRole";

    public static class SIGNUP_INPUT_ARGUMENT {
      public static final String Input = "input";
    }

    public static class SIGNIN_INPUT_ARGUMENT {
      public static final String Input = "input";
    }

    public static class MODIFYROLE_INPUT_ARGUMENT {
      public static final String Email = "email";

      public static final String RoleId = "roleId";
    }
  }

  public static class ROLE {
    public static final String TYPE_NAME = "Role";

    public static final String Id = "id";

    public static final String Name = "name";

    public static final String Description = "description";

    public static final String Users = "users";

    public static final String Permissions = "permissions";
  }

  public static class PROVINCE {
    public static final String TYPE_NAME = "Province";

    public static final String Id = "id";

    public static final String Name = "name";

    public static final String Country = "country";

    public static final String Cities = "cities";
  }

  public static class PERMISSION {
    public static final String TYPE_NAME = "Permission";

    public static final String Id = "id";

    public static final String Name = "name";

    public static final String Description = "description";

    public static final String Roles = "roles";
  }

  public static class IDTYPE {
    public static final String TYPE_NAME = "IdType";

    public static final String Id = "id";

    public static final String Name = "name";

    public static final String Users = "users";
  }

  public static class GENDER {
    public static final String TYPE_NAME = "Gender";

    public static final String Id = "id";

    public static final String Name = "name";

    public static final String Users = "users";
  }

  public static class COUNTRY {
    public static final String TYPE_NAME = "Country";

    public static final String Id = "id";

    public static final String Name = "name";

    public static final String Provinces = "provinces";
  }

  public static class CITY {
    public static final String TYPE_NAME = "City";

    public static final String Id = "id";

    public static final String Name = "name";

    public static final String Users = "users";

    public static final String Province = "province";
  }

  public static class SIGNUPINPUT {
    public static final String TYPE_NAME = "signUpInput";

    public static final String Id = "id";

    public static final String IdType = "idType";

    public static final String City = "city";

    public static final String Gender = "gender";

    public static final String Role = "role";

    public static final String IdentificationNumber = "identificationNumber";

    public static final String FirstName = "firstName";

    public static final String LastName = "lastName";

    public static final String BirthDate = "birthDate";

    public static final String PhoneNumber = "phoneNumber";

    public static final String Email = "email";

    public static final String Password = "password";

    public static final String AvatarUrl = "avatarUrl";

    public static final String Address = "address";
  }

  public static class SIGNININPUT {
    public static final String TYPE_NAME = "signInInput";

    public static final String Email = "email";

    public static final String Password = "password";
  }
}
