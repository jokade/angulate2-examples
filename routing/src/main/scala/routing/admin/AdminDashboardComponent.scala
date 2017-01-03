//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing.admin

import angulate2.std._
import angulate2.ext.tags.simple._
import angulate2.router.ActivatedRoute
import rxjs.Observable

import scala.scalajs.js
import scalatags.Text.all._

@Component(
  template = tpl(
    p("Dashboard"),
    p("Session ID: {{ sessionId | async }}"),
    a(id:="anchor"),
    p("Token: {{ token | async }}")
  )
)
class AdminDashboardComponent(route: ActivatedRoute) extends OnInit {
  var sessionId: Observable[String] = _
  var token: Observable[String] = _

  override def ngOnInit(): Unit = {
    sessionId = route.queryParams.map( (params,_) => params.getOrElse("session_id","None") )

    token = route.fragment.map( (fragment,_) => fragment.getOrElse("None") )
  }
}
