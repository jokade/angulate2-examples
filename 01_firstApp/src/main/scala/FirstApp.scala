import scalajs.js
import angulate2._

@js.annotation.JSExport
object FirstApp {

  // start the main component
  angular.bootstrapWith[AppController]
  
}


@Component(
  selector = "my-app",
  template = "<h1>My first Angular 2 App</h1>"
)
class AppController
