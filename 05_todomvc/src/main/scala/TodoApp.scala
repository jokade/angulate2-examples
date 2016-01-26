//     Project: angulate2-examples
//      Module: 05 TodoMVC
// Description: Angulat2 App Component for the TodoMVC example

// Copyright (c) 2016 Johannes Kastner <jokade@karchedon.de>
// Based on the Angular2 TodoMVC example for Angular2 (https://github.com/tastejs/todomvc/tree/master/examples/angular2/)

import angulate2._

@Component(
  selector = "todo-app",
  templateUrl = "src/main/resources/html/app.html",
  providers = @@[TodoStore]
)
class TodoApp(val todoStore: TodoStore) {

}
