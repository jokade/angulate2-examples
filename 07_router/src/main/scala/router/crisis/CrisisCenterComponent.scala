//     Project: angulate2-examples
//      Module: 07 Router
// Description: CrisisCenterComponent

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package router.crisis

import angulate2._
import angulate2.router.{RDef, RouteConfig, RouterOutlet}

@Component(
template =
  """<h2>CRISIS CENTER</h2>
     <router-outlet></router-outlet>""",
  directives = @@[RouterOutlet],
  providers =  @@[CrisisService]
)
@RouteConfig(
  RDef(path = "/",    name = "CrisisCenter", component = @#[CrisisListComponent], useAsDefault = true),
  RDef(path = "/:id", name = "CrisisDetail", component = @#[CrisisDetailComponent])
)
class CrisisCenterComponent {

}
