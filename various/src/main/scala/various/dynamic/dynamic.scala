//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package various.dynamic

import angulate2.ext.dynamic.DynamicExtModule
import angulate2.std._

@NgModule(
  imports = @@[DynamicExtModule],
  declarations = @@[DynamicExampleComponent]
)
class DynamicModule

@Component(
    template = """<div *xngInclude="tpl"></div>"""
)
//@debug
class DynamicExampleComponent {
  def tpl() = "<div>Dynamic Template!</div>"


}
