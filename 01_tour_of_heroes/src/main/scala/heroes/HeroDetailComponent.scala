//     Project: angulate2-examples
// Description: The HeroDetailComponent

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2._

import scala.scalajs.js

@Component(
  selector = "my-hero-detail",
  template =
    """<div *ngIf="hero">
       <h2>{{hero.name}} details!</h2>
       <div><label>id: </label>{{hero.id}}</div>
       <div>
         <label>name: </label>
         <input [(ngModel)]="hero.name" placeholder="name">
       </div>
       </div>
    """.stripMargin
)
class HeroDetailComponent {
  @Input
  var hero: Hero = _
}
