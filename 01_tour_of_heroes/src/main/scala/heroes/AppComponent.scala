//     Project: angulate2-examples
//      Module: 01_tour_of_heroes
// Description: Root component for the Tour of Heroes app

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2._

@Component(
  selector = "my-app",
  template =
    """<h1>{{title}}</h1>
       <a routerLink="/heroes">Heroes</a>
       <router-outlet></router-outlet>
    """
)
class AppComponent {
  val title = "Tour of Heroes"
}
