//     Project: angulate2-examples
//      Module: 08 Bootstrap
// Description: Main application component

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package bootstrap

import angulate2._
import angulate2.router.ROUTER_DIRECTIVES

@Component(
  selector = "app",
  template = "Hello!"
//  templateUrl = "src/main/resources/html/app.html"
//  directives = @@[ROUTER_DIRECTIVES]
)
@debug
class AppComponent {
  var isCollapsed = true
}
