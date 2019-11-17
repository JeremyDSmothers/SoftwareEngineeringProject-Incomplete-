DROP TABLE r405.InMatch;
DROP TABLE r405.User;
DROP TABLE r405.Match;

-- tables created
CREATE TABLE IF NOT EXISTS r405.User
(
	UserName VARCHAR(32) NOT NULL,
	Password VARBINARY(32) NOT NULL,
	VictoryCount INT NOT NULL,
	DefeatCount INT NOT NULL,
	PRIMARY KEY(UserName)
);

CREATE TABLE IF NOT EXISTS r405.Match
(
	Id INT NOT NULL AUTO_INCREMENT,
	StartTime DATETIME NOT NULL,
	Winner VARCHAR(32),
	PRIMARY KEY(Id)
);

CREATE TABLE IF NOT EXISTS r405.InMatch
(
	MatchId INT NOT NULL,
	UserName VARCHAR(32) NOT NULL,
	PRIMARY KEY(MatchId, UserName)
);

-- InMatch table foreign keys added
ALTER TABLE r405.InMatch ADD CONSTRAINT fk_InMatch_User FOREIGN KEY(UserName) REFERENCES r405.User(UserName);
ALTER TABLE r405.InMatch ADD CONSTRAINT fk_InMatch_Match FOREIGN KEY(MatchId) REFERENCES r405.Match(Id);

-- sample sql of new accounts being created
INSERT INTO r405.User VALUES('matthew',aes_encrypt('passwordm','key'),0,0);
INSERT INTO r405.User VALUES('sarah',aes_encrypt('passwords','key'),0,0);
INSERT INTO r405.User VALUES('antone',aes_encrypt('passworda','key'),0,0);
INSERT INTO r405.User VALUES('jeremy',aes_encrypt('passwordj','key'),0,0);
INSERT INTO r405.User VALUES('edger',aes_encrypt('passworde','key'),0,0);

-- sample sql of decrypting user passwords for authorization
SELECT UserName, aes_decrypt(password,'key') from r405.User WHERE UserName = "matthew" AND aes_decrypt(password,'key') = 'passwordm';

-- sample sql of new match being created and users entering the match, with matthew winning
INSERT INTO r405.Match (startTime) VALUES(NOW());

INSERT INTO r405.InMatch VALUES(1,'matthew');
INSERT INTO r405.InMatch VALUES(1,'sarah');
INSERT INTO r405.InMatch VALUES(1,'antone');
INSERT INTO r405.InMatch VALUES(1,'jeremy');
INSERT INTO r405.InMatch VALUES(1,'edger');

UPDATE r405.Match SET Winner='matthew' WHERE Id=1;
UPDATE r405.User SET VictoryCount = VictoryCount + 1 WHERE UserName = 'matthew';

-- sample of getting information on the victor of match ID 1
SELECT UserName, VictoryCount, DefeatCount FROM r405.USER AS u INNER JOIN r405.Match AS m ON u.UserName = m.Winner; 
