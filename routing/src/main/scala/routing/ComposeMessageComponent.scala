//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing

import angulate2.ext.tags.simple._
import angulate2.router.Router
import angulate2.std._
import org.scalajs.dom.window.setTimeout

import scalatags.Text.all._

@Component(
  template = tpl(
    h3("Contact Crisis Center"),
    div(ngIf:="details")("{{ details }}"),
    div(
      div( label("Message: ") ),
      div( textarea(ngModel:="message", rows:="10", cols:="35", ngDisabled:="sending") )
    ),
    p(ngIf:="!sending")(
      button(ngClick:="send()")("Send"),
      button(ngClick:="cancel()")("Cancel")
    )
  ),
  styles = @@@(":host { position: relative; bottom: 10%; }"),
  animations = @@@(routing.animations.slideInDownAnimation)
)
class ComposeMessageComponent(router: Router) {
  @HostBinding("@routeAnimation")
  val routeAnimation = true
  @HostBinding("style.display")
  val display = "block"
  @HostBinding("style.position")
  val position = "absolute"

  var sending = false
  var details = undef[String]

  def send(): Unit = {
    sending = true
    details = "Sending Message..."

    setTimeout(() => {
      sending = false
      closePopup()
    },1000)
  }

  def cancel(): Unit = closePopup()

  def closePopup(): Unit = router.navigateTo(%%%(outlets = %%%(popup = null)))
}
