//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes
import angulate2.ext.inMemoryWebApi.InMemoryDbService

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, ScalaJSDefined}

@JSExport
@ScalaJSDefined
class HeroesData extends InMemoryDbService {
  override def createDb(): js.Any = js.Dictionary("heroes" -> js.Array(
    Hero(11,"Mr. Nice"),
    Hero(12,"Narco"),
    Hero(13,"Bombasto"),
    Hero(14,"Celeritas"),
    Hero(15,"Magenta"),
    Hero(16,"RubberMan"),
    Hero(17,"Dynama"),
    Hero(18,"Dr IQ"),
    Hero(19,"Magma"),
    Hero(20,"Tornados")
  ))
}
