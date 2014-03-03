CREATE TABLE disciplina (
	_id CHAR(20) PRIMARY KEY NOT NULL,
	nome CHAR(60),
	sala CHAR(50),
	semestre CHAR(50)
);

CREATE TABLE evento (
	event_id INTEGER PRIMARY KEY AUTOINCREMENT,
	event_datahora DATETIME,
	event_duracao DATETIME,
	event_descricao CHAR(200)
);

CREATE TABLE evento_avaliativo (
	event_id INTEGER PRIMARY KEY AUTOINCREMENT,
	event_datahora DATETIME,
	event_duracao DATETIME,
	event_descricao CHAR(220),
	event_aval_tipo CHAR(20),
	event_aval_pontuacao FLOAT,
	fk_disc_id CHAR(20),
	FOREIGN KEY (fk_disc_id) REFERENCES disciplina(_id)
		ON DELETE CASCADE
);

CREATE TABLE sticky_notes (
	stk_id INTEGER PRIMARY KEY AUTOINCREMENT,
	stk_text CHAR(120),
	stk_xpos INTEGER,
	stk_ypos INTEGER
);

CREATE TABLE alunos (
	_id INTEGER PRIMARY KEY AUTOINCREMENT,
	nome CHAR(50),
	matricula CHAR(15),
	fk_disc_id CHAR(20),
	nota REAL,
	FOREIGN KEY(fk_disc_id) REFERENCES disciplina(_id)
		ON DELETE CASCADE		
);