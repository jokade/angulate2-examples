
import scalajs.js
import angulate2._

//@Injectable
class FriendsService {
  val names = js.Array("Aarav","Martín","Shannon","Ariana","Kai")
}

@Component(
  selector = "display",
  template = """<p>My name: {{ myName }}</p>
                <p>Friends:</p>
                <ul>
                  <li *ngFor="let name of names">{{name}}</li>
                </ul> 
                <p *ngIf="names.length > 3">You have many friends!</p>
             """,
  directives = js.Array( ng.common.NgFor, ng.common.NgIf )
)
class DisplayApp {
  val myName = "Alice"
  val names = js.Array("Aarav","Martín","Shannon","Ariana","Kai")
  //def names = friends.names
}

