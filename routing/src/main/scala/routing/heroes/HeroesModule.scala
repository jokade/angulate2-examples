//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing.heroes

import angulate2.common.CommonModule
import angulate2.forms.FormsModule
import angulate2.std._

@NgModule(
  imports = @@[CommonModule,FormsModule,HeroesRoutingModule],
  declarations = @@[HeroListComponent,HeroDetailComponent],
  providers = @@[HeroService]
)
class HeroesModule {

}
