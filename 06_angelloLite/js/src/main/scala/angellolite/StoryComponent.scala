//     Project: angulate2-examples
//      Module: 06 AngelloLite
// Description: Component for rendering of StoryS
package angellolite

import angulate2._

@Component(
  selector = "story",
  templateUrl = "src/main/resources/html/story.html",
  inputs = @@("story")
)
class StoryComponent {
  var story: Story = _

}
