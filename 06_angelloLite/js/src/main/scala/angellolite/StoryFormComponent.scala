//     Project: angulate2-examples
//      Module: 06 AngelloLite
// Description: Component for editing StoryS

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package angellolite

import angulate2._

import scala.scalajs.js

@Component(
  selector = "story-form",
  templateUrl = "src/main/resources/html/story-form.html",
  inputs = @@("story")
)
class StoryFormComponent(storyService: StoryService) {
  var story: Story = _

  val statuses = js.Array( "Back Log", "To Do", "In Progress", "Code Review", "QA Review", "Verified", "Done")
  val types = js.Array("Feature","Enhancement","Bug","Spike")

  def save() = storyService.saveStory(story)
}

@Data
case class Status(name: String)
