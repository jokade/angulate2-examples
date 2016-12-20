//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package various

import angulate2.platformBrowser.BrowserModule
import angulate2.router.{Route, RouterModule}
import angulate2.std._

@NgModule(
  imports = @@[BrowserModule] :+
    RouterModule.forRoot(@@@(Route(
      path = "sizer",
      component = %%[SizerExampleComponent]
    ),
      Route(
        path = "",
        component = %%[TocComponent]
      ))),
  declarations = @@[AppComponent,TocComponent,SizerExampleComponent,SizerComponent],
  bootstrap = @@[AppComponent]
)
class AppModule {

}
