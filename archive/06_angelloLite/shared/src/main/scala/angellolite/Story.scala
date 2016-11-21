//     Project: angulate2-examples
//      Module: 06 AngelloLite
// Description: Data class for user stories

// Copyright (c) 2016. Distributed under the MIT License (see included LICENSE file).
package angellolite

import angulate2.Data

@Data
case class Story(var id: Int,
                 var title: String,
                 var description: String,
                 var criteria: String,
                 var status: String,
                 var storyType: String,
                 var reporter: String,
                 var assignee: String)

