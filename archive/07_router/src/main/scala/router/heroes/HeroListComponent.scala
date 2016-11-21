//     Project: angulate2 (https://github.com/jokade/angulate2)
//      Module: 07 Router
// Description: HeroListComponent

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package router.heroes

import angulate2._
import angulate2.router.Router

import scala.scalajs.js

@Component(
  template =
    """<h2>HEROES</h2>
      |<ul>
      |  <li *ngFor="let hero of heroes"
      |     (click)="onSelect(hero)">
      |    <span class="badge">{{hero.id}}</span> {{hero.name}}
      |  </li>
      |</ul>""".stripMargin

)
class HeroListComponent(service: HeroService, router: Router) extends OnInit {
  var heroes: js.Array[Hero] = _

  override def ngOnInit(): Unit = service.getHeroes.onSuccess( heroes = _ )

  def onSelect(hero: Hero) = router.navigate("HeroDetail", "id" -> hero.id)
}
