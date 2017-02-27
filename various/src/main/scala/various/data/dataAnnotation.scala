//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2017. Distributed under the MIT License (see included LICENSE file).
package various.data

import angulate2.common.CommonModule
import angulate2.std._
import angulate2.ext.data._

import scala.scalajs.js

@NgModule(
  imports = @@[CommonModule],
  declarations = @@[DataAnnotationExampleComponent]
)
class DataAnnotationModule

@Component(
  template =
    """{{tree.root.label}}:
      |<ul>
      |  <li *ngFor="let item of tree.root.children">{{item.label}}</li>
      |</ul>
    """.stripMargin
)
class DataAnnotationExampleComponent {
  val tree = Tree( Node(1, children = Seq(Node(2,Some("child1")))) )
  js.Dynamic.global.console.log(Node(1,label=Some("root"),children= Seq(
    Node(2, label = Some("child1")),
    Node(3)
  )))
}

@Data
@debug
case class Node(id: Int, label: Option[String] = None, children: Seq[Node] = Nil)

@Data
case class Tree(root: Node, props: Map[Int,Boolean] = Map.empty[Int,Boolean])
