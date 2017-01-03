//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing.heroes

import angulate2.std._

@Routes(
  root = false,
  Route(path = "heroes", component = %%[HeroListComponent]),
  Route(path = "hero/:id", component = %%[HeroDetailComponent])
)
class HeroesRoutingModule
