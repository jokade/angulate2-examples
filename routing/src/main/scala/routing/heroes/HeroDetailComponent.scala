//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing.heroes

import angulate2.ext.tags.simple._
import angulate2.router.{ActivatedRoute, Router}
import angulate2.std._

import scala.scalajs.js
import scalatags.Text.all._

@Component(
  template = tpl(
    h2("HEROES"),
    div(ngIf:="hero")(
      h3("{{ hero.name }}"),
      div(
        label("Id: "),"{{ hero.id }}",
        input(ngModel:="hero.name", placeholder:="name")
      ),
      p(
        button(ngClick:="gotoHeroes()")("Back")
      )
    )
  ),
  animations = @@@(routing.animations.slideInDownAnimation)
)
//@debug
class HeroDetailComponent(route: ActivatedRoute, router: Router, service: HeroService) extends OnInit {
  var hero: js.UndefOr[Hero] = _

  @HostBinding("@routeAnimation")
  val routeAnimation = true

  @HostBinding("style.display")
  val display = "block"

  @HostBinding("style.position")
  val position = "absolute"

  override def ngOnInit(): Unit = route.params
    .switchMap( (params,_) => service.getHero(params("id").toInt) )
    .subscribe( this.hero = _ )

  def gotoHeroes(): Unit = {
    val heroId = hero.map(_.id)
    router.navigate(@@@("/heroes", %%%(id = heroId, foo = "foo")))
  }
}
