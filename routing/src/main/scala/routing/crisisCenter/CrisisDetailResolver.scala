//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing.crisisCenter

import angulate2.router.{ActivatedRouteSnapshot, Resolve, Router, RouterStateSnapshot}
import angulate2.std._
import rxjs.ValOrObs

@Injectable
class CrisisDetailResolver(crisisService: CrisisService, router: Router) extends Resolve[Crisis] {
  override def resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): ValOrObs[Crisis] =
    crisisService.getCrisis(route.params("id").toInt) map {
      case Some(crisis) => crisis
      case None =>
        router.navigateTo("/crisis-center")
        null
    }
}
