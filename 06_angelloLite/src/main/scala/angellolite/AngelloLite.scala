//     Project: angulate2-examples
//      Module: 06 AngelloLite
// Description: Main application component

// Port of the AngelloLite app presented in the Book "Angular.js in Action" by L. Ruebbelke
package angellolite

import angulate2._
import angulate2.http.{HTTP_PROVIDERS, Http}

import scala.scalajs.js

@Component(
  selector = "angello-lite",
  templateUrl = "src/main/resources/html/main.html",
  directives = @@[StoryComponent,StoryFormComponent],
  providers = @@[StoryService] :+ HTTP_PROVIDERS
)
class AngelloLite(storyService: StoryService) {
  var currentStory: js.UndefOr[Story] = js.undefined

  def stories = storyService.stories

  def setCurrentStory(story: Story): Unit = currentStory = story

  def createStory() = storyService.create()
}

