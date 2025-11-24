# Tennis scoreboard

#### A web application that implements a tennis match score board.


## Features

- **Frontend**: HTML/CSS, JavaScript, JSP
- **Backend**: HTTP - GET requests. The project is written on java servlets.
- **Database**: Hibernate, H2 (in-memory SQL database)
- **Tests**: JUnit5

## Project motivation
* Create a client-server application with a web interface
* Gain practical experience with the Hibernate ORM
* Build a simple web interface without third-party libraries
* Get familiar with the MVC(S) architectural pattern


## Application functionality
#### Working with matches :
* Create a new match
* View completed matches, search matches by player names
* Calculate scores in the current match

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


## Database

#### Table `Players`
| Колонка    | Тип     | Комментарий                 |
|------------|---------|-----------------------------|
| `ID`       | int     | auto-increment, primary key |
| `Name`     | varchar | Player name                 |


#### Table `Matches`
| Колонка   | Тип     | Комментарий |
|-----------|---------|-------------|
| `ID`      | int     | User ID, auto-increment, primary key |
| `Player1` | int | First player ID, external key to Players.ID|
| `Player2` | int | Second player ID, external key to Players.ID|
| `Winner`  | int | Winner ID, external key to Players.ID|


## MVCS 
I used the MVCS (Model-View-Controller-Service) architectural design pattern. It's an extension of the classic MVC pattern and further separates the logic for interacting with the database or network into a separate component—the "Service." This allows for even better isolation of different parts of the application, improving their maintainability and testability.
![MVCS ](https://s01.pic4net.com/di-H9SDG7.png)

## Tests
For testing I used JUnit5

#### Example Test
```
public class MatchScoreCalculationServiceTest {

    private MatchScoreCalculationService matchScoreCalculationService;
    ParseVariableMatch parseVariableMatch= Mockito.mock(ParseVariableMatch.class);

    @BeforeEach
    public void setUp() {
        matchScoreCalculationService = new MatchScoreCalculationService();
    }


    @Test
    @DisplayName("Test winner game parties")
    public void testWinnerGameParties() {
        Match match = new Match(new Players("Sergey"), new Players("Andrey"), 0, 0, 0, 0, "40", "0");
        ParseVariableMatch parseVariableMatch= Mockito.spy(ParseVariableMatch.class);
        parseVariableMatch.setA(40);
        MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService(parseVariableMatch);

        match = matchScoreCalculationService.collectingPointInMatch(match, "ScoreOne");
        int totalGame=match.getGamesScorePlayerOne();
        assertEquals(1, totalGame);

    }

    @Test
    @DisplayName("Test advantage")
    public void testAdvantage(){
        Match match = new Match(new Players("Sergey"), new Players("Andrey"), 0, 0, 0, 0, "40", "40");
        ParseVariableMatch parseVariableMatch= Mockito.spy(ParseVariableMatch.class);
        parseVariableMatch.setA(40);
        parseVariableMatch.setB(40);
        MatchScoreCalculationService matchScoreCalculationService = new MatchScoreCalculationService(parseVariableMatch);

        match = matchScoreCalculationService.collectingPointInMatch(match, "ScoreOne");
        boolean advantage=match.isAdvantage();
        assertEquals(true, advantage);

    }
```
