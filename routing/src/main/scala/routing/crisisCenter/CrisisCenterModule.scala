//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing.crisisCenter

import angulate2.common.CommonModule
import angulate2.forms.FormsModule
import angulate2.std._
import routing.CanDeactivateGuard

@NgModule(
  imports = @@[CommonModule,FormsModule,CrisisCenterRoutingModule],
  declarations = @@[CrisisCenterComponent,CrisisListComponent,CrisisDetailComponent,CrisisCenterHomeComponent],
  providers = @@[CrisisService]
)
class CrisisCenterModule

@Routes(
  providers = @@[CrisisDetailResolver]
)(
  root = false,
  Route(path = "", redirectTo = "/crisis-center", pathMatch = "full"),
  Route(path = "crisis-center", component = %%[CrisisCenterComponent],
    children = @@@(
      Route(path = "", component = %%[CrisisListComponent],
        children = @@@(
          Route(path = ":id", component = %%[CrisisDetailComponent], canDeactivate = @@[CanDeactivateGuard], resolve = %%%(crisis = %%[CrisisDetailResolver])),
          Route(path = "", component = %%[CrisisCenterHomeComponent])
        ))
    ))
)
class CrisisCenterRoutingModule
