//     Project: angulate2-examples
//      Module: 07 Router
// Description: Main application component

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package router

import _root_.router.crisis.CrisisCenterComponent
import _root_.router.heroes.{HeroDetailComponent, HeroListComponent, HeroService}
import angulate2._
import angulate2.router.{RDef, ROUTER_DIRECTIVES, RouteConfig}

@Component(
  selector = "my-app",
  directives = @@[ROUTER_DIRECTIVES],
  providers = @@[HeroService,DialogService],
  template =
    """<h1>Component Router</h1>
      |<nav>
      |  <a [routerLink]="['CrisisCenter']">Crisis Center</a>
      |  <a [routerLink]="['Heroes']">Heroes</a>
      |</nav>
      |<router-outlet></router-outlet>""".stripMargin
)
@RouteConfig(
  RDef(path = "/crisis-center/...", name = "CrisisCenter", component = @#[CrisisCenterComponent], useAsDefault = true),
  RDef(path = "/heroes",            name = "Heroes",       component = @#[HeroListComponent]),
  RDef(path = "/hero/:id",          name = "HeroDetail",   component = @#[HeroDetailComponent])
)
class AppComponent {
}
