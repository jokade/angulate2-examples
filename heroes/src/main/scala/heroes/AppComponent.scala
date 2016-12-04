//     Project: angulate2-examples
//      Module: 01_tour_of_heroes
// Description: Root component for the Tour of Heroes app

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2.std._

@Component(
  selector = "my-app",
  template =
    """<h1>{{title}}</h1>
       <nav>
         <a routerLink="/dashboard" routerLinkActive="active">Dashboard</a>
         <a routerLink="/heroes" routerLinkActive="active">Heroes</a>
       </nav>
       <router-outlet></router-outlet>
    """,
  styleUrls = @@@("src/main/resources/app.component.css")
)
class AppComponent {
  val title = "Tour of Heroes"
}
