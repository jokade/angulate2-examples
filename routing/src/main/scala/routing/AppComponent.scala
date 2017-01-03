//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package routing

import angulate2.std._
import angulate2.ext.tags.simple._

import scalatags.Text.all._
import scalatags.Text.tags2._

@Component(
  selector = "my-app",
  template = tpl(
    h1("Angular Router"),
    nav(
      routerLink(url = "/crisis-center", active="active")("Crisis Center"),
      routerLink(url = "/heroes", active="active")("Heroes"),
      routerLink(url = "/admin", active="active")("Admin"),
      routerLink(url = "/login", active = "active")("Login"),
      bindRouterLink("[{ outlets: {popup: ['compose']} }]")("Contact")
    ),
    routerOutlet,
    routerOutlet("popup")
  )
)
class AppComponent {

}
