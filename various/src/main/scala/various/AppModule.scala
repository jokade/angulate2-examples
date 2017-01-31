//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package various

import angulate2.platformBrowser.BrowserModule
import angulate2.router.Route
import angulate2.std._
import slogging._
import various.dynamic.{DynamicExampleComponent, DynamicModule}
import various.hostBinding.{HostBindingExampleComponent, HostBindingModule}
import various.pipe.{CustomPipeModule, PowerBoosterComponent}
import various.sizer.{SizerExampleComponent, SizerModule}

@NgModule(
  imports = @@[
    BrowserModule,
    SizerModule,
    HostBindingModule,
    CustomPipeModule,
    DynamicModule,
    AppRoutes],
  declarations = @@[AppComponent,TocComponent],
  bootstrap = @@[AppComponent]
)
class AppModule {
//  LoggerConfig.factory = ConsoleLoggerFactory()
  LoggerConfig.factory = PrintLoggerFactory()
  LoggerConfig.level = LogLevel.DEBUG
}

@Routes(
  root = true,
  Route(
    path = "sizer",
    component = %%[SizerExampleComponent]
  ),
  Route(
    path = "hostBinding",
    component = %%[HostBindingExampleComponent]
  ),
  Route(
    path = "customPipe",
    component = %%[PowerBoosterComponent]
  ),
  Route(
    path = "dynamic",
    component = %%[DynamicExampleComponent]
  ),
  Route(
    path = "",
    component = %%[TocComponent]
  )
)
class AppRoutes
