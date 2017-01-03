//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing

import angulate2.core.animations._
import angulate2.std._

object animations {

  val slideInDownAnimation =
    trigger("routeAnimation",@@@(
      state("*",
        style(%%%(
          opacity = 1,
          transform = "translateX(0)"
        ))),
      transition(":enter",@@@(
        style(%%%(
          opacity = 0,
          transform = "translateX(-100%)"
        )),
        animate("0.2s ease-in")
      )),
      transition(":leave",@@@(
        animate("0.5s ease-out", style(%%%(
          opacity = 0,
          transform = "translateY(100%)"
        )))
      ))
    ))

}
