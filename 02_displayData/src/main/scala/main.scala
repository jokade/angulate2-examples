
import scalajs.js
import angulate2._

@Injectable
class FriendsService {
  val names = js.Array("Aarav","Martín","Shannon","Ariana","Kai")
}

@Component(
  selector = "display",
  template = """<p>My name: {{ myName }}</p>
                <p>Friends:</p>
                <ul>
                  <li *for="#name of names">{{name}}</li>
                </ul> 
                <p *if="names.length > 3">You have many friends!</p>
             """,
  directives = js.Array( angular.For, angular.If ),
  injectables = js.Array( @@[FriendsService] )
)
class DisplayComponent(friends: FriendsService) {
  val myName = "Alice"
  //val names = js.Array("Aarav","Martín","Shannon","Ariana","Kai")
  def names = friends.names
}

@js.annotation.JSExport
object Main {
  angular.bootstrapWith[DisplayComponent]

}
