DROP TABLE IF EXISTS days;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS projectTimes;

CREATE TABLE days (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  dates DATE NOT NULL,
  start TIMESTAMP NOT NULL,
  finish TIMESTAMP NOT NULL
);

CREATE TABLE projets (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  projectId INT NOT NULL,
  description VARCHAR(255) NOT NULL
);

CREATE TABLE projetTimes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  start TIMESTAMP NOT NULL,
  finish TIMESTAMP NOT NULL,
  FOREIGN KEY (project) REFERENCES project (id),
  FOREIGN KEY (days) REFERENCES day (id)
);