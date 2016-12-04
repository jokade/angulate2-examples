# angulate2-examples
Examples for [angulate2](https://github.com/jokade/angulate2) (a Scala.js binding library for [Angular 2](http://angular.io)).

Getting Started
---------------
### Prerequisites
Node.js must be installed to run the examples out of the box.

### Step 1
Clone this repository and run `sbt fastOptJS`.

### Step 2
Go to any of the subdirectories and run `npm install` to install the required JS dependecies (Angular2, RxJS).
If you don't want to install the dependencies separately for every subdir, create an empty `node_modules` folder in the top-level project and then create a symbolic link to it in every subfolder before you run `npm install`. 

### Step 3
Start any of the example by running `npm start` in any of the example subfolders.

## List of Examples
* `heroes/`: the introductory Angular2 "[Tour of Heroes](https://angular.io/docs/ts/latest/tutorial/)" tutorial.
