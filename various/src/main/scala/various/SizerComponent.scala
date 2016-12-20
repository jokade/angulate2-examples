//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package various

import angulate2.core.EventEmitter
import angulate2.ext.{classModeJS, debug}
import angulate2.std._

@Component(
  template =
    """<my-sizer [(size)]="fontSizePx"></my-sizer>
      |<div [style.font-size.px]="fontSizePx">Resizable Text</div>
    """.stripMargin
)
class SizerExampleComponent {
  var fontSizePx = 12
}

@Component(
  selector = "my-sizer",
  template =
    """<div>
      |<button (click)="dec()" title="smaller">-</button>
      |<button (click)="inc()" title="bigger">+</button>
      |<label [style.font-size.px]="size">FontSize: {{size}}px</label>
      |</div>
    """.stripMargin
)
@debug
class SizerComponent {
  @Input
  var size: Int = _

  @Output
  var sizeChange = new EventEmitter[Int]()

  def dec() = resize(-1)
  def inc() = resize(+1)

  def resize(delta: Int) {
    size = Math.min(40, Math.max(8, size + delta))
    sizeChange.emit(size)
  }
}

