//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing

import angulate2.std._
import rxjs.Observable

@Injectable
class AuthService {
  var isLoggedIn = false

  var redirectUrl = undef[String]

  def login(): Observable[Boolean] = Observable.of(true).delay(1000).`do`( _ => isLoggedIn = true )

  def logout(): Unit = isLoggedIn = false
}
