//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package directive

import angulate2.core.{Directive => _, Input => _, _}
import angulate2.ext.classModeJS
import angulate2.std._

import scala.scalajs.js

@Directive(
  selector = "[myHighlight]"
)
@classModeJS
class HighlightDirective(el: ElementRef, renderer: Renderer) {
  private var _defaultColor = "red"

  @Input("myHighlight")
  var highlightColor: js.UndefOr[String] = js.undefined

  @Input
  def defaultColor_=(colorName: js.UndefOr[String]): Unit = if(colorName.isDefined) _defaultColor = colorName.get

  @HostListener("mouseenter")
  def onMouseEnter(): Unit = {
    highlight( highlightColor.getOrElse(_defaultColor) )
  }

  @HostListener("mouseleave")
  def onMouseLeave(): Unit = {
    highlight(null)
  }

  private def highlight(color: String): Unit = {
    renderer.setElementStyle(el.nativeElement, "backgroundColor", color)
  }
}

