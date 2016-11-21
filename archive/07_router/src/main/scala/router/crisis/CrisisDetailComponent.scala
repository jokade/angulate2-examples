//     Project: angulate2-examples
//      Module: 07 Router
// Description: CrisisDetailComponent

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package router.crisis

import _root_.router.DialogService
import angulate2._
import angulate2.router.{CanDeactivate, ComponentInstruction, RouteParams, Router}

import scala.scalajs.js
import scala.scalajs.js.Any
import js.UndefOr._

@Component(
  template =
    """<div *ngIf="crisis">
      |  <h3>"{{editName}}"</h3>
      |  <div>
      |    <label>Id: </label>{{crisis.id}}</div>
      |  <div>
      |    <label>Name: </label>
      |    <input [(ngModel)]="editName" placeholder="name"/>
      |  </div>
      |  <button (click)="save()">Save</button>
      |  <button (click)="cancel()">Cancel</button>
      |</div>""".stripMargin
)
class CrisisDetailComponent(service: CrisisService,
                            router: Router,
                            routeParams: RouteParams,
                            dialogService: DialogService) extends OnInit with CanDeactivate {
  var crisis: Crisis = _
  var editName: String = _

  def cancel() {
    editName = this.crisis.name
    gotoCrises()
  }

  def save() {
    crisis.name = this.editName
    gotoCrises()
  }

  def gotoCrises() = router.navigate("CrisisCenter")

  override def ngOnInit(): Unit = service.getCrisis(routeParams.int("id")) onSuccess{ c =>
    crisis = c
    editName = c.name
  }

  override def routerCanDeactivate(nextInstruction: ComponentInstruction, prevInstruction: ComponentInstruction): Any =
    // Allow synchronous navigation (`true`) if no crisis or the crisis is unchanged.
    if( any2undefOrA(crisis).isEmpty || crisis.name == editName ) true
    // Otherwise ask the user with the dialog service and return its
    // promise which resolves to true or false when the user decides
    else dialogService.confirm("Discard changes?")

}
