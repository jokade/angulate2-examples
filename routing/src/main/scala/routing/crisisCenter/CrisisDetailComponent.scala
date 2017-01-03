//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing.crisisCenter

import angulate2.std._
import angulate2.ext.tags.simple._
import angulate2.router.{ActivatedRoute, Router}
import routing.{CanComponentDeactivate, DialogService}
import rxjs.{RxPromise, ValOrObs}

import scala.scalajs.js
import scalatags.Text.all._

@Component(
  template = tpl(
    div(ngIf:="crisis")(
      h3("{{ crisis.name }}"),
      div(
        label("Id: "),"{{ crisis.id }}",
        input(ngModel:="crisis.name", placeholder:="name")
      ),
      p(
        button(ngClick:="gotoCrisises()")("Back")
      )
    )
  ),
  animations = @@@(routing.animations.slideInDownAnimation)
)
//@debug
class CrisisDetailComponent(route: ActivatedRoute, router: Router, dialogService: DialogService)
  extends OnInit with CanComponentDeactivate {
  var crisis = undef[Crisis]
  var editName: String = _

  @HostBinding("@routeAnimation")
  val routeAnimation = true

  @HostBinding("style.display")
  val display = "block"

  @HostBinding("style.position")
  val position = "absolute"

  override def canDeactivate =
    if(crisis.isEmpty || crisis.get.name == editName) true
    else dialogService.confirm("Discard changes?")

  override def ngOnInit(): Unit = route.subscribeData("crisis"){ (c:Crisis) =>
    editName = c.name
    this.crisis = c
  }

  def gotoCrises(): Unit = {
    val crisisId = crisis.map(_.id)
    router.navigateRelativeTo(route,"../", %%%(crisisId, foo = "foo"))
  }

  def cancel() {
    gotoCrises()
  }

  def save() {
    this.crisis.get.name = editName
    gotoCrises()
  }

}
