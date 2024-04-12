Betting Game Application

Overview

The Betting Game Application is a simple odds-based game developed using Kotlin and Spring Boot. It allows players to register for an account, place bets on randomly generated numbers, and win or lose credits based on the outcome. The application also provides functionality to view wallet transactions and retrieve the results of bets.

Features

Player registration: Players can register for an account by providing their name, surname, and a unique username. Each player account is assigned a unique ID and starts with a wallet balance of 1000 credits.
Betting game: Players can place bets of any value on numbers between 1 and 10. The game generates a random number between 1 and 10, and players win or lose credits based on the outcome and the odds of their bet.
Wallet management: Each bet deducts the bet amount from the player's wallet balance. If the player wins a bet, the winnings are added to their wallet balance. Once a wallet balance is depleted, the player can no longer place bets.

Technologies Used

Kotlin: Programming language used for backend development.
Spring Boot: Framework used for building the application.
Spring WebFlux: Reactive programming module used for handling API requests and responses.
H2 Database: In-memory database used for storing player accounts, bets, and wallet transactions.
Postman: API client used for testing the application's endpoints.

Installation and Setup
Clone the repository to your local machine.
Open the project in your preferred IDE (e.g., IntelliJ IDEA).
Build and run the application using Gradle or Maven.
Access the application endpoints using Postman or any other API client.

API Endpoints

POST /api/players/register: Register a new player account.
POST /api/bets/place: Place a bet on a number between 1 and 10.
GET /api/players/{playerId}/wallet: Get the wallet balance of a player.
GET /api/bets/{betId}/result: Get the result of a specific bet.
GET /api/players/{playerId}/bets: Get a list of all bets placed by a player.

Future Improvements

Implement authentication and authorization for player accounts.
Add more features such as leaderboard, player statistics, and game history.
Improve error handling and validation for API endpoints.
Deploy the application to a cloud platform for scalability and availability.