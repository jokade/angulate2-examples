//     Project: angulate2-examples
//      Module: 01_tour_of_heroes
// Description: NgModule for the Tour of Heroes app

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2._
import angulate2.extra.inMemoryWebApi.{InMemoryWebApiModule,InMemoryBackendConfigArgs}
import angulate2.forms.FormsModule
import angulate2.http.HttpModule
import angulate2.platformBrowser.BrowserModule
import angulate2.router.{Route, RouterModule}

import scala.scalajs.js

@NgModule(
  imports = @@[BrowserModule,FormsModule,HttpModule] :+
    InMemoryWebApiModule.forRoot(%%[HeroesData],InMemoryBackendConfigArgs(delay = 0)) :+
    RouterModule.forRoot(js.Array(Route(
      path = "heroes",
      component = %%[HeroesComponent]
    ),Route(
      path = "dashboard",
      component = %%[DashboardComponent]
    ),Route(
      path = "",
      redirectTo = "/dashboard",
      pathMatch = "full"
    ),Route(
      path = "detail/:id",
      component = %%[HeroDetailComponent]
    ))),
  providers = @@[HeroService],
  declarations = @@[AppComponent,HeroesComponent,HeroDetailComponent,DashboardComponent,HeroSearchComponent],
  bootstrap = @@[AppComponent]
)
class AppModule {
}
