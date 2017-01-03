//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing.crisisCenter

import angulate2.std._
import rxjs.RxPromise

import scala.scalajs.js

@Injectable
class CrisisService {
  private val crises = @@@(
    Crisis(1, "Dragon Burning Cities"),
    Crisis(2, "Sky Rains Great White Sharks"),
    Crisis(3, "Giant Asteroid Heading For Earth"),
    Crisis(4, "Procrastinators Meeting Delayed Again")
  )

  private val crisesPromise = RxPromise.resolve(crises)

  def getCrises(): RxPromise[js.Array[Crisis]] = crisesPromise

  def getCrisis(id: Int): RxPromise[Option[Crisis]] = crisesPromise.map( crises => crises.find(_.id==id) )
}
