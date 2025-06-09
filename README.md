# Tennis scoreboard

#### A web application that implements a tennis match score board.


## Features

- **Frontend**: HTML/CSS, JavaScript, JSP
- **Backend**: HTTP - GET requests. The project is written on java servlets.
- **Database**: Hibernate, H2 (in-memory SQL database)
- **Tests**: JUnit5

## Pages info

### Main
The home page, which has buttons to go to the following pages: create a **new match** , **completed matches**

![Main](https://s01.pic4net.com/di-84K613.png)

### Matches
A page with all registered players. The page implements pagination and search for the player by name.

![Matches](https://s01.pic4net.com/di-73WU7E.png)

### Start new match
It is a page with a form for registering a match. The page displays two fields for entering the names of the players and one button for registering the match, after clicking on which the match will begin.

![Start new match](https://s01.pic4net.com/di-6L236X.png)


### Current match
Redirect to this page after successful registration. The match is managed on this page. A table with the values of sets, games, and player points is displayed. There is a "score" button in the player's row to increase the player's score.

![Current match](https://s01.pic4net.com/di-2FX4JI.png)


### Result-match
The result of the current completed match is displayed.

![Result-match](https://s01.pic4net.com/di-US0X9Q.png)


## Diagram Description
![DiagramDB](https://s01.pic4net.com/di-JP3E4K.png)

This diagram represents the structure of the `MATCHES`, `PLAYERS` and their relationships.
