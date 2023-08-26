CREATE TABLE leagues (
    league_id SERIAL PRIMARY KEY,
    league_name VARCHAR(50) NOT NULL
);
CREATE TABLE referees (
    referee_id SERIAL PRIMARY KEY,
    referee_name VARCHAR(50) NOT NULL,
    league_id INTEGER,
    FOREIGN KEY (league_id) REFERENCES leagues(league_id)
);

CREATE TABLE teams (
    team_id SERIAL PRIMARY KEY,
    team_name VARCHAR(50) NOT NULL,
    league_id INTEGER,
    FOREIGN KEY (league_id) REFERENCES leagues(league_id)
);

CREATE TABLE coaches (
    coach_id SERIAL PRIMARY KEY,
    coach_name VARCHAR(50) NOT NULL,
    team_id INTEGER,
    FOREIGN KEY (team_id) REFERENCES teams(team_id)
);
CREATE TABLE players (
    player_id SERIAL PRIMARY KEY,
    player_name VARCHAR(50) NOT NULL,
    team_id INTEGER,
    FOREIGN KEY (team_id) REFERENCES teams(team_id)
);

CREATE TABLE matches (
    match_id SERIAL PRIMARY KEY,
    team1_id INTEGER NOT NULL,
    team2_id INTEGER NOT NULL,
    full_time_score VARCHAR(10),
    match_date TIMESTAMP,
    FOREIGN KEY (team1_id) REFERENCES teams(team_id),
    FOREIGN KEY (team2_id) REFERENCES teams(team_id)
);

CREATE TABLE goal_scorers (
    goal_id SERIAL PRIMARY KEY,
    match_id INTEGER,
    player_id INTEGER,
    FOREIGN KEY (match_id) REFERENCES matches(match_id),
    FOREIGN KEY (player_id) REFERENCES players(player_id)
);



-- SELECT gs.player_id, players.player_name, gs.goal_id, matches.match_id, matches.match_date,
-- FROM goal_scorers gs
--          JOIN matches ON gs.match_id = matches.match_id
--          JOIN players ON gs.player_id = players.player_id
-- WHERE players.player_name = 'Neymar';