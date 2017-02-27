//     Project: angulate2-examples
//      Module:
// Description:

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package heroes

import angulate2.std._
import angulate2.router.Router
import rxjs.{Observable, Subject}

import scala.scalajs.js

@Component(
  selector = "hero-search",
  templateUrl = "/src/main/resources/hero-search.component.html",
  styleUrls = @@@("src/main/resources/hero-search.component.css"),
  providers = @@[HeroSearchService]
)
class HeroSearchComponent(heroSearchService: HeroSearchService, router: Router) extends OnInit {
  private val searchTerms = new Subject[String]()
  var heroes: Observable[js.Array[Hero]] = _

  def search(term: String): Unit = {
    searchTerms.next(term)
  }

  def gotoDetail(hero: Hero): Unit = router.navigateTo("/detail",hero.id)

  override def ngOnInit(): Unit = this.heroes = searchTerms
    .debounceTime(300)
    .distinctUntilChanged()
    .switchMap( (term,_) => if(term.trim=="") Observable.of(js.Array[Hero]()) else heroSearchService.search(term) )
    .`catch`{ (err,_) =>
      js.Dynamic.global.console.log(err)
      Observable.of(js.Array[Hero]())
    }

}
