package com.authb.api_auth.generated.datafetchers;

import com.authb.api_auth.generated.types.User;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import graphql.schema.DataFetchingEnvironment;

@DgsComponent
public class UserByIdDatafetcher {
  @DgsData(
      parentType = "Query",
      field = "userById"
  )
  public User getUserById(DataFetchingEnvironment dataFetchingEnvironment) {
    return null;
  }
}
