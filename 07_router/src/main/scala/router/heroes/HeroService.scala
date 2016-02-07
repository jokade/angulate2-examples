//     Project: angulate2 (https://github.com/jokade/angulate2)
//      Module: 07 Router
// Description: HeroService

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package router.heroes

import angulate2._
import rxjs.core.Promise

import scala.scalajs.js

@Injectable
class HeroService {
  def getHeroes =  _heroesPromise

  def getHero(id: Int) = _heroesPromise.onSuccess(_.find(_.id==id).get)

  private val _heroes = js.Array(
    Hero(11, "Mr. Nice"),
    Hero(12, "Narco"),
    Hero(13, "Bombasto"),
    Hero(14, "Celeritas"),
    Hero(15, "Magneta"),
    Hero(16, "RubberMan")
  )

  private val _heroesPromise = Promise.resolve(_heroes)
}

