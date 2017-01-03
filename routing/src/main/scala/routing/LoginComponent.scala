//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing

import angulate2.std._
import angulate2.ext.tags.simple._
import angulate2.router.{NavigationExtras, Router}

import scalatags.Text.all._

@Component(
  template = tpl(
    h2("LOGIN"),
    p("{{message}}"),
    p(
      button(ngClick:="login()", ngIf:="!authService.isLoggedIn")("Login"),
      button(ngClick:="logout()", ngIf:="authService.isLoggedIn")("Logout")
    )
  )
)
class LoginComponent(val authService: AuthService, val router: Router) {
  var message = undef[String]

  def setMessage() = message = "Logged " + (if(authService.isLoggedIn) "in" else "out")

  private val navigationExtras = NavigationExtras(
    preserveQueryParams = true,
    preserveFragment = true
  )

  def login(): Unit = {
    message = "Trying to log in ..."

    authService.login().subscribe{ _ =>
      setMessage()
      if(authService.isLoggedIn) {
        val url = authService.redirectUrl.getOrElse("/crisis-center/admin")
        router.navigateTo(navigationExtras)(url)
      }
    }
  }

  def logout(): Unit = {
    authService.logout()
    setMessage()
  }
}
