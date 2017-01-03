//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing.crisisCenter

import angulate2.std._
import angulate2.ext.tags.simple._
import angulate2.router.{ActivatedRoute, Router}
import rxjs.Observable

import scala.scalajs.js
import scalatags.Text.all._

@Component(
  template = tpl(
    ul(cls := "items")(
      li(ngFor := "let crisis of crises | async",
        ngBindClass("selected") := "isSelected(crisis)",
        ngClick := "onSelect(crisis)")(
        span(cls:="badge")("{{ crisis.id }}"),
        "{{ crisis.name }}"
      )
    ),
    routerOutlet
  )
)
class CrisisListComponent(router: Router, route: ActivatedRoute, service: CrisisService) extends OnInit {
  var crises: Observable[js.Array[Crisis]] = _
  private var selectedId: Option[Int] = _

  def onSelect(crisis: Crisis): Unit = {
    selectedId = Some(crisis.id)
    router.navigateRelativeTo(route,crisis.id)
  }

  def isSelected(crisis: Crisis): Boolean = selectedId.isDefined && selectedId.get == crisis.id

  override def ngOnInit(): Unit = crises = route.params
    .switchMap{ (params,_) =>
      selectedId = params.get("id").map(_.toInt)
      service.getCrises()
    }
}
