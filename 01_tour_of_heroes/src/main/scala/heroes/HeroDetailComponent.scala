//     Project: angulate2-examples
// Description: The HeroDetailComponent

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2._
import angulate2.router.ActivatedRoute
import angulate2.common.Location


@Component(
  selector = "my-hero-detail",
  templateUrl = "/src/main/resources/hero-detail.component.html",
  styleUrls = @@("src/main/resources/hero-detail.component.css")
)
class HeroDetailComponent(heroService: HeroService,
                          route: ActivatedRoute,
                          location: Location) extends OnInit {
  @Input
  var hero: Hero = _

  def goBack(): Unit = location.back()

  def save(): Unit = ()

  override def ngOnInit(): Unit = route.params
    .switchMap( (params,i) => heroService.getHero(params("id").toInt) )
    .subscribe(this.hero = _)
}
