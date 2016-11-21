//     Project: angulate2 (https://github.com/jokade/angulate2)
//      Module: 07 Router
// Description: HeroDetailComponent

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package router.heroes

import angulate2._
import angulate2.router.{RouteParams, Router}

@Component(
  template =
    """<h2>HEROES</h2>
      |<div *ngIf="hero">
      |  <h3>"{{hero.name}}"</h3>
      |  <div>
      |    <label>Id: </label>{{hero.id}}</div>
      |  <div>
      |    <label>Name: </label>
      |    <input [(ngModel)]="hero.name" placeholder="name"/>
      |  </div>
      |  <button (click)="gotoHeroes()">Back</button>
      |</div>""".stripMargin
)
class HeroDetailComponent(router: Router, routeParams: RouteParams, service: HeroService) extends OnInit {
  var hero: Hero = _

  def ngOnInit() = service.getHero(routeParams.int("id")) onSuccess (hero = _)

  def gotoHeroes() = router.navigate("Heroes")

}
