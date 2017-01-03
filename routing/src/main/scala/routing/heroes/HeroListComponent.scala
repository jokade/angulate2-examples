//     Project: Default (Template) Project
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing.heroes

import angulate2.ext.tags.simple._
import angulate2.router.{ActivatedRoute, Router}
import angulate2.std._
import rxjs.Observable

import scala.scalajs.js
import scalatags.Text.all._

@Component(
  template = tpl(
    h2("HEROES"),
    ul(cls := "items")(
      li(ngFor := "let hero of heroes | async",
        ngBindClass("selected") := "isSelected(hero)",
        ngClick := "onSelect(hero)")(
        span(cls:="badge")("{{ hero.id }}"),
        "{{ hero.name }}"
      )
    ),
    button(routerLink:="/sidekicks")("Go to sidekicks")
  )
)
class HeroListComponent(router: Router, route: ActivatedRoute, service: HeroService) extends OnInit {
  var heroes: Observable[js.Array[Hero]] = _
  private var selectedId: Option[Int] = _

  def onSelect(hero: Hero): Unit = router.navigateTo("/hero",hero.id)

  def isSelected(hero: Hero): Boolean = selectedId.isDefined && selectedId.get == hero.id

  override def ngOnInit(): Unit = heroes = route.params
    .switchMap{ (params,_) =>
      selectedId = params.get("id").map(_.toInt)
      service.getHeroes
    }
}
