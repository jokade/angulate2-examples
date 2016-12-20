//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package various

import angulate2.std._

@Component(
  selector = "my-app",
  template = "<router-outlet></router-outlet>"
)
class AppComponent {

}

@Component(
  template =
    """<h1>Various Examples</h1>
      |<nav>
      |  <a routerLink="/sizer">Two-way binding (sizer component)</a>
      |</nav>
    """.stripMargin
)
class TocComponent
