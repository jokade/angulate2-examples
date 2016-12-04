//     Project: angulate2-examples
//      Module: 01_tour_of_heroes
// Description: Dashboard component for the Tour of Heroes app

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2.std._

import scala.scalajs.js

@Component(
  selector = "my-dashboard",
  templateUrl = "/src/main/resources/dashboard.component.html",
  styleUrls = @@@("src/main/resources/dashboard.component.css")
)
class DashboardComponent(heroService: HeroService) extends OnInit {
  var heroes: js.Array[Hero] = _

  override def ngOnInit(): Unit = heroService.getHeroes.onFulfilled ( res => this.heroes = res.slice(1,5) )
}
object DashboardComponent {
  val mydata = 1
}