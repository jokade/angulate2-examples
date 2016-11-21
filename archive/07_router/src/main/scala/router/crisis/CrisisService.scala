//     Project: angulate2-examples
//      Module: 07 Router
// Description: CrisisService

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package router.crisis

import angulate2._
import rxjs.core.Promise

import scala.scalajs.js

@Injectable
class CrisisService {

  def getCrises = _crisesPromise

  def getCrisis(id: Int) = _crisesPromise.onSuccess( _.find(_.id==id).get )

  private val _crises = js.Array(
    Crisis(1, "Princess Held Captive"),
    Crisis(2, "Dragon Burning Cities"),
    Crisis(3, "Giant Asteroid Heading For Earth"),
    Crisis(4, "Release Deadline Looms")
  )

  private val _crisesPromise = Promise.resolve(_crises)
}
