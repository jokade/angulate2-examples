//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing.heroes

import angulate2.std._
import rxjs.RxPromise

import scala.scalajs.js

@Injectable
class HeroService {
  private val heroes = @@@(
    Hero(11, "Mr. Nice"),
    Hero(12, "Narco"),
    Hero(13, "Bombasto"),
    Hero(14, "Celeritas"),
    Hero(15, "Magneta"),
    Hero(16, "RubberMan")
  )

  private val heroesPromise = RxPromise.resolve(heroes)

  def getHeroes(): RxPromise[js.Array[Hero]] = heroesPromise

  def getHero(id: Int): RxPromise[Hero] = heroesPromise.map( heroes => heroes.find(_.id==id).get )
}
