//     Project: angulate2-examples
//      Module: 05 TodoMVC
// Description: Todo service.

// Copyright (c) 2016 Johannes Kastner <jokade@karchedon.de>
// Based on the Angular2 TodoMVC example for Angular2 (https://github.com/tastejs/todomvc/tree/master/examples/angular2/)
import angulate2._

import scala.scalajs.js

@Injectable
class TodoStore {

  def todos: js.Array[Todo] = js.Array(new Todo("hello"))
}
