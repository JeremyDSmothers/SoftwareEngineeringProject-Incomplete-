CREATE TABLE IF NOT EXISTS r405.User
(
	UserName		VARCHAR2(32)	NOT NULL,
	Password		VARBINARY(32)	NOT NULL,
	VictoryCount	INT				NOT NULL,
	DefeatCount		INT				NOT NULL,
	PRIMARY KEY(UserName)
);

CREATE TABLE IF NOT EXISTS r405.Match
(
	Id				INT				NOT NULL AUTO_INCREMENT,
	StartTime		DATETIME		NOT NULL,
	Winner			VARCHAR2(32),
	PRIMARY KEY(Id)
);

CREATE TABLE IF NOT EXISTS r405.InMatch
(
	MatchId			INT				NOT NULL,
	UserName		VARCHAR2(32)	NOT NULL,
	PRIMARY KEY(MatchId, UserName)
);

-- InMatch table foreign keys 
ALTER TABLE r405.InMatch ADD CONSTRAINT fk_InMatch_User FOREIGN KEY(UserName) REFERENCES r405.User(UserName);
ALTER TABLE r405.InMatch ADD CONSTRAINT fk_InMatch_Match FOREIGN KEY(MatchId) REFERENCES r405.Match(Id);

-- sample sql of new account created
INSERT INTO Users VALUES('matthew',aes_encrypt('password','key'),0,0);

-- sample sql of new match be created
INSERT INTO Match (startTime) VALUES(NOW());