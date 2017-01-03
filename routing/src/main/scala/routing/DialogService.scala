//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package routing

import angulate2.std._
import rxjs.RxPromise

@Injectable
class DialogService {

  def confirm(message: String) = RxPromise[Boolean]( (resolve,_) => {
    resolve(org.scalajs.dom.window.confirm(message))
  })
}
