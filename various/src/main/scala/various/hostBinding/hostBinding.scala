//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package various.hostBinding

import angulate2.std._

@NgModule(
  declarations = @@[HostBindingExampleComponent,HostBindingComponent]
)
class HostBindingModule

@Component(
  template = "<my-hostbinding></my-hostbinding>",
  styles = @@@(
    """.valid {
         font-size: 30px;
         background-color: green;
       }""")
)
class HostBindingExampleComponent

@Component(
  selector = "my-hostbinding",
  template =
    """<div>HostBinding</div>
    """
)
class HostBindingComponent {
//  @HostBinding("class")
//  var classNames: String = "valid"
  @HostBinding("class.valid")
  var isValid: Boolean = true
}
