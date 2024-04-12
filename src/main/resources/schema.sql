CREATE TABLE IF NOT EXISTS player (
                                      id INT AUTO_INCREMENT PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL,
                                      surname VARCHAR(255) NOT NULL,
                                      username VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS wallet (
                                       id INT AUTO_INCREMENT PRIMARY KEY,
                                       player_id INT,
                                       balance INT NOT NULL CHECK (balance >= 0),
                                       FOREIGN KEY (player_id) REFERENCES player(id)
);


CREATE TABLE IF NOT EXISTS bet (
                                   id INT AUTO_INCREMENT PRIMARY KEY,
                                   player_id INT,
                                   bet_amount INT NOT NULL CHECK (bet_amount >= 0),
                                   bet_number INT NOT NULL CHECK (bet_number >= 1 AND bet_number <= 10),
                                   generated_number INT NOT NULL CHECK (generated_number >= 1 AND generated_number <= 10),
                                   winnings INT NOT NULL CHECK (winnings >= 0),
                                   FOREIGN KEY (player_id) REFERENCES player(id)
);
