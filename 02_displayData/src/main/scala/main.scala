import scalajs.js
import biz.enef.angulate2._

@Component(
  selector = "display",
  template = """<p>My name: {{ myName }}</p>
                <p>Friends:</p>
                <ul>
                  <li *for="#name of names">{{name}}</li>
                </ul> 
             """,
  directives = js.Array( angular.For )
)
class DisplayComponent {
  val myName = "Alice"
  val names = js.Array("Aarav","Martín","Shannon","Ariana","Kai")
}

@js.annotation.JSExport
object Main {
  angular.register[DisplayComponent]
  angular.bootstrapWith[DisplayComponent]
}
