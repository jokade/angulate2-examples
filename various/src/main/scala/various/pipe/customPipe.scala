//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package various.pipe

import angulate2.core.{Pipe, PipeTransform0, PipeTransform1, PipeTransform2}
import angulate2.std._

@Pipe(
  name = "exponentialStrength"
)
class ExponentialStrengthPipe
  extends PipeTransform0[Int,Int] with PipeTransform1[Int,Int,Int] with PipeTransform2[Int,Int,Int,Int] {

  override def transform(value: Int): Int = Math.pow(value,2).toInt

  override def transform(value: Int, arg1: Int): Int = Math.pow(value,arg1).toInt

  override def transform(value: Int, arg1: Int, arg2: Int): Int = Math.pow(value,arg1*arg2).toInt
}

@Component(
  template =
    """<h2>Power Booster</h2>
      |<p>Power boost: {{2 | exponentialStrength}}
      |<p>Super power boost: {{2 | exponentialStrength : 10}}
      |<p>Mega power boost: {{2 | exponentialStrength : 2 : 10}}
    """.stripMargin
)
class PowerBoosterComponent

@NgModule(
  declarations = @@[PowerBoosterComponent,ExponentialStrengthPipe]
)
class CustomPipeModule