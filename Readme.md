# Unide recruitment play | java task

This project is based on public star wars api - https://swapi.dev/. It's well documented and it's easy to type responses as java classes.


## Development server

Run `sbt ~run` for a dev server. Navigate to `http://localhost:9000/`. The app will automatically reload if you change any of the source files.
### current endpoints:
* `/` returns a 'Hello!' string
* `/first-planet` controller uses StarWarsService to get data about planet with id 1 and displays a `.toString()` of Planet classes that is a result of parsed json.


# Task

* Fork this repository
* Create an endpoint `/planet/:id` that will return a `toString()` of `Universe.class` created from the planet with :id.
* The `Universe.class` should consist two fields: 
  * `Planet planet` 
  * `List<Person> people` (you will have to create Person class based on https://swapi.dev/documentation)
* To create Universe class based on Planet from api you'll also have to make requests to swapi on addresses contained in `Planet.residents`
* Commit your changes to a new branch `feature/api`.
* Create pull request to `main` of our repository and send us an email with notification.

Good luck! 👾

- - - -
