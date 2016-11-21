//     Project: angulate2 (https://github.com/jokade/angulate2)
//      Module: 07 Router
// Description: CrisisListComponent

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package router.crisis

import angulate2._
import angulate2.router.Router

import scala.scalajs.js

@Component(
  template =
    """<ul>
      |  <li *ngFor="let crisis of crises"
      |    (click)="onSelect(crisis)">
      |    <span class="badge">{{crisis.id}}</span> {{crisis.name}}
      |  </li>
      |</ul>""".stripMargin
)
class CrisisListComponent(service: CrisisService, router: Router) extends OnInit {

  var crises: js.Array[Crisis] = _

  def onSelect(crisis: Crisis) = router.navigate("CrisisDetail", "id"->crisis.id)

  override def ngOnInit(): Unit = service.getCrises.onSuccess( crises = _ )
}
