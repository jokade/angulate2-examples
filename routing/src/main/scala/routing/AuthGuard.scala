//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing

import angulate2.router._
import angulate2.std._

@Injectable
class AuthGuard(authService: AuthService, router: Router) extends CanActivate with CanActivateChild {

  override def canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) = checkLogin(state.url)

  override def canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot) = canActivate(childRoute,state)

  def checkLogin(url: String): Boolean =
    if(authService.isLoggedIn) true
    else {
      authService.redirectUrl = url
      val sessionId = 123456789
      val navigationExtras = NavigationExtras(
        queryParams = %%%(session_id = sessionId),
        fragment = "anchor"
      )
      router.navigateTo(navigationExtras)("/login")
      false
    }
}
