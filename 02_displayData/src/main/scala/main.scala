
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
                  <li *ng-for="#name of names">{{name}}</li>
                </ul> 
                <p *ng-if="names.length > 3">You have many friends!</p>
             """,
  directives = js.Array( angular.NgFor, angular.NgIf ),
  appInjector = js.Array( @@[FriendsService] )
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
