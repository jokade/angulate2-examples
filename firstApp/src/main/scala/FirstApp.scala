
import scalajs.js
import biz.enef.angulate2._

@js.annotation.JSExport
object FirstApp {

  // register the component
  // (this call is required by angulate2, due to some limitations of JS code generated with Scala.js)
  angular.register[AppController]

  // run the starting component
  angular.bootstrapWith[AppController]
  
}


@Component(
  selector = "my-app",
  template = "<h1>My first Angular 2 App</h1>"
)
class AppController
