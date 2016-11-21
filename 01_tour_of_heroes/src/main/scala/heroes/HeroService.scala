//     Project: angulate2-examples
// Description: Data service for Heroes

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2._

import scala.concurrent.Future
import scala.scalajs.js

@Injectable
class HeroService {
  def getHeroes = Future.successful(heroes)

  private val heroes = js.Array(
    Hero(11,"Mr. Nice"),
    Hero(12,"Narco"),
    Hero(13,"Bombasto"),
    Hero(14,"Celeritas"),
    Hero(15,"Magenta"),
    Hero(16,"RubberMan"),
    Hero(17,"Dynama"),
    Hero(18,"Dr IQ"),
    Hero(19,"Magma"),
    Hero(20,"Tornado")
  )
}
