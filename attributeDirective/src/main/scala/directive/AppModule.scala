//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package directive

import angulate2.platformBrowser.BrowserModule
import angulate2.std._

@NgModule(
  imports = @@[BrowserModule],
  declarations = @@[AppComponent,HighlightDirective],
  bootstrap = @@[AppComponent]
)
class AppModule {

}
