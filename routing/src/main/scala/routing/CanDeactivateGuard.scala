//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing

import angulate2.router.{ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot}
import angulate2.std._
import de.surfice.smacrotools.createJS
import rxjs.ValOrObs

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined

@ScalaJSDefined
trait CanComponentDeactivate extends js.Object {
  def canDeactivate: ValOrObs[Boolean]
}

@Injectable
class CanDeactivateGuard extends CanDeactivate[CanComponentDeactivate] {
  override def canDeactivate(component: CanComponentDeactivate, route: ActivatedRouteSnapshot, state: RouterStateSnapshot)  =
    if(component.asInstanceOf[js.UndefOr[_]].isDefined) component.canDeactivate
    else true
}
