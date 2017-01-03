//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package routing

import angulate2.forms.FormsModule
import angulate2.platformBrowser.BrowserModule
import angulate2.std._
import routing.admin.AdminModule
import routing.crisisCenter.CrisisCenterModule
import routing.heroes.HeroesModule

@NgModule(
  imports = @@[
    BrowserModule,
    FormsModule,
    HeroesModule,
    CrisisCenterModule,
    AdminModule,
    LoginroutingModule,
    AppRoutingModule],
  declarations = @@[
    AppComponent,
    LoginComponent,
    PageNotFoundComponent,
    ComposeMessageComponent],
  providers = @@[
    DialogService,
    CanDeactivateGuard],
  bootstrap = @@[AppComponent]
)
class AppModule


@Routes(
  providers = @@[
    CanDeactivateGuard]
)(
  root = true,
  Route(path = "compose", component = %%[ComposeMessageComponent], outlet = "popup"),
  Route(path = "", redirectTo = "/heroes", pathMatch = "full"),
  Route(path = "**", component = %%[PageNotFoundComponent] )
)
class AppRoutingModule

