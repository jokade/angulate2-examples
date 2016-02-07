//     Project: angulate2-examples
//      Module: 07 Router
// Description: Async modal dialog service

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package router

import angulate2._
import rxjs.core.{IPromise, Promise}

import scala.scalajs.js

@Injectable
class DialogService {
  /**
   * Ask user to confirm an action. `message` explains the action and choices.
   * Returns promise resolving to `true`=confirm or `false`=cancel
   */
  def confirm(message: String) : IPromise[Boolean] =
    Promise.resolve( js.Dynamic.global.window.confirm(message).asInstanceOf[Boolean] )
}
