import scalajs.js
import biz.enef.angulate2._

@Component(
  selector = "display",
  template = """<p>My name: {{ myName }}</p>
                <p>Friends:</p>
                <ul>
                  <li *for="#name of names">{{name}}</li>
                </ul> 
                <p *if="names.length > 3">You have many friends!</p>
             """,
  directives = js.Array( angular.For, angular.If )
)
class DisplayComponent {
  val myName = "Alice"
  val names = js.Array("Aarav","Martín","Shannon","Ariana","Kai")
}

@js.annotation.JSExport
object Main {
  angular.bootstrapWith[DisplayComponent]
}
