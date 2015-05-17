import scalajs.js
import biz.enef.angulate2._

@Component(
  selector = "todo-list",
  template = """<ul>
                  <li *for="#todo of todos">{{todo}}</li>
                </ul> 

                <input #todotext>
                <button (click)="addTodo(todotext.value)">Add Todo</button>
             """,
  directives = js.Array( angular.For, angular.If )
)
class TodoList {
  var todos = js.Array("Eat Breakfast", "Walk Dog", "Breathe")

  def addTodo(todo: String) = todos.push(todo)
}

@js.annotation.JSExport
object Main {
  angular.register[TodoList]
  angular.bootstrapWith[TodoList]
}
