//     Project: angulate2-examples
//      Module: 01_tour_of_heroes
// Description: Heroes component for the Tour of Heroes app

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2._

import scala.scalajs.js
import scalajs.concurrent.JSExecutionContext.Implicits.queue

@Component(
  selector = "my-heroes",
  template =
    """<h2>My Heroes</h2>
      |<ul class="heroes">
      |  <li *ngFor="let hero of heroes"
      |    [class.selected]="hero === selectedHero"
      |    (click)="onSelect(hero)">
      |   <span class="badge">{{hero.id}}</span> {{hero.name}}
      |  </li>
      |</ul>
      |<my-hero-detail [hero]="selectedHero"></my-hero-detail>
    """.stripMargin
)
//@debug
class HeroesComponent(heroService: HeroService) extends OnInit {
  var heroes: js.UndefOr[js.Array[Hero]] = _
  var selectedHero: js.UndefOr[Hero] = js.undefined

  def onSelect(hero: Hero) = selectedHero = hero

  def getHeroes(): Unit = heroService.getHeroes onSuccess {
    case r => heroes = r
  }

  override def ngOnInit(): Unit = getHeroes()
}

