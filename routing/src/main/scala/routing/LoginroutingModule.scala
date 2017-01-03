//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing

import angulate2.std._

@Routes(
  providers = @@[
    AuthGuard,
    AuthService]
)(
  root = false,
  Route(path = "login", component = %%[LoginComponent])
)
class LoginroutingModule {

}
